package com.tas.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tas.TasSQL.TasSQL;
import com.tas.util.Access;
import com.tas.util.Upload;


public class VideoUploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		Connection conn = TasSQL.getConnection();
		String sql="insert into video values(?);";
		
		Upload up=new Upload();
		String video_pic_name=up.uploadPic(arg0, arg1, getServletContext());
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, video_pic_name);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(video_pic_name!=null&&!"".equals(video_pic_name)){
			arg0.setAttribute("video_pic_name", video_pic_name);
		}else{
			arg0.setAttribute("error_info", Access.up_Book_error);
		}
		arg0.getRequestDispatcher("video.jsp").forward(arg0, arg1);
	}

}
