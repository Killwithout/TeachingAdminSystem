package com.tas.servlet;

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tas.TasSQL.TasSQL;

public class leaveMessage<E> extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * message
		**/
		String login_name=req.getParameter("login_name");
		//System.out.print(login_name+"*-*************login_name************");
		String titles=req.getParameter("titles");
		String bodys=req.getParameter("bodys");
		
		Date date=new Date();
		String times=date.toLocaleString();
		System.out.println("date="+date.toLocaleString()+"******");
		//String bodys=req.getParameter("bodys");
		
		//System.out.print(titles+"*-*************1************"+bodys);
		Connection conn=TasSQL.getConnection();
		String sql="insert into message(titles,bodys,times) values(?,?,?)";
		String sql2="select * from message";
		
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,titles);
			pst.setString(2, bodys);
			pst.setString(3, times);
			
			boolean flag=pst.execute();
			//System.out.print(titles+"*-**********2***************"+bodys);
		
			Statement pstm=conn.createStatement();
			ResultSet rs=pstm.executeQuery(sql2);
			String title="";
			String body="";
			String time="";
			
			while(rs.next()){
				title=rs.getString(1);
				body=rs.getString(2);
				time=rs.getString(3);
			}
		
			/**
			req.setAttribute("titles",title);
			req.setAttribute("bodys",body);
			req.setAttribute("times",time);
			**/
			List list=new ArrayList();
				list.add(title);
				list.add(body);
				list.add(time);
				req.setAttribute("list",list);
			req.getRequestDispatcher("LeaveMessage.jsp").forward(req,resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
