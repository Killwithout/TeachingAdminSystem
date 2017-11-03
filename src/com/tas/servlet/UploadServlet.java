package com.tas.servlet;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tas.util.Option;
import com.tas.util.Upload;




public class UploadServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		Upload up=new Upload();
		String book_pic_nameString=up.uploadPic(arg0, arg1, getServletContext());
		String pathString="";
		if(book_pic_nameString!=null&&!"".equals(book_pic_nameString)){
			arg0.setAttribute("pic_name", book_pic_nameString);
		}else{
			arg0.setAttribute("error_info", Option.up_Book_error);
		}
		pathString="addTeacher.jsp";
		arg0.getRequestDispatcher(pathString).forward(arg0, arg1);
	}

}
