package com.tas.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.Application;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tas.TasSQL.TasSQL;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/**
		 * ��¼Ȩ��
		**/
			String struts=req.getParameter("QuanXian");
//			String login_name=req.getParameter("login_name");
//			req.getSession().setAttribute("login_name", login_name);
//			System.out.println(struts+"********1****************");
			
			if("student".equals(struts)){
				StudentServlet(req,resp);
			}else if("teacher".equals(struts)){
				TeacherServlet(req,resp);
			}else if("admin".equals(struts)){
				AdminServlet(req,resp);
			}
	}
	
	/**
	 * ѧ������
	**/
	private void StudentServlet(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("type", "1");
		String login_name=req.getParameter("login_name");
		Connection conn=TasSQL.getConnection();
		String sql="select s_name from student where s_id=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, login_name);
			ResultSet rs=pst.executeQuery();
			boolean flag=false;
			String path="";
			String name="";
			while(rs.next()){
				name=rs.getString(1)+"  "+"ͬѧ";
				flag=true;
			}
			if(flag){
	    		path="main.html";
	    		req.getSession().setAttribute("name",name);
	    		if((Integer)getServletContext().getAttribute("count")!=null){
	    			int i=(Integer)getServletContext().getAttribute("count");
	    			getServletContext().setAttribute("count", i=i+1);
	    		}else{
	    			getServletContext().setAttribute("count",1);
	    		}
	    	}else{
	    		path="login.jsp";
	    		req.setAttribute("errorinfo", "�û����������");
	    	}
	    	req.getRequestDispatcher(path).forward(req,resp);
			} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʦ����
	**/
	private void TeacherServlet(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("type", "2");
		System.out.println("teacher come in!");
		String login_name=req.getParameter("login_name");
		String login_pass=req.getParameter("login_pass");
		
		req.getSession().setAttribute("login_name", login_name);
		
		System.out.println(login_name+"********2****************"+login_pass);
		
		Connection conn=TasSQL.getConnection();
		String sql="select t_name from teacher where t_id=? and t_pass=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, login_name);
			pst.setString(2, login_pass);
			ResultSet rs=pst.executeQuery();
			boolean flag=false;
			String path="";
			String name="";
			String pass="";
			while(rs.next()){
				name=rs.getString(1)+"  "+"��ʦ";
				flag=true;
			}
			if(flag){
	    		path="main.html";
	    		req.getSession().setAttribute("name",name);
	    		if((Integer)getServletContext().getAttribute("count")!=null){
	    			int i=(Integer)getServletContext().getAttribute("count");
	    			getServletContext().setAttribute("count", i=i+1);
	    		}else{
	    			getServletContext().setAttribute("count",1);
	    		}
	    	}else{
	    		path="login.jsp";
	    		req.setAttribute("errorinfo", "��ʦ�û����������");
	    	}
	    	req.getRequestDispatcher(path).forward(req,resp);
			} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ����Ա����
	**/
	private void AdminServlet(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("type", "3");
		String login_name=req.getParameter("login_name");
		Connection conn=TasSQL.getConnection();
		String sql="select t_name from teacher where t_id=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, login_name);
			ResultSet rs=pst.executeQuery();
			boolean flag=false;
			String path="";
			String name="";
			while(rs.next()){
				name=rs.getString(1)+"  "+"����Ա";
				flag=true;
			}
			if(flag){
	    		path="main.html";
	    		req.getSession().setAttribute("name",name);
	    		if((Integer)getServletContext().getAttribute("count")!=null){
	    			int i=(Integer)getServletContext().getAttribute("count");
	    			getServletContext().setAttribute("count", i=i+1);
	    		}else{
	    			getServletContext().setAttribute("count",1);
	    		}
	    	}else{
	    		path="login.jsp";
	    		req.setAttribute("errorinfo", "�û����������");
	    	}
	    	req.getRequestDispatcher(path).forward(req,resp);
			} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
