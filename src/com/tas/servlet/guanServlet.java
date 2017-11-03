package com.tas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.collections.Factory;
import com.tas.daoimp.DaoFactory;
import com.tas.vo.Role;
import com.tas.vo.Teacher;


public class guanServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String struts=req.getParameter("struts");
		if(struts.equals("do_login")){
			g_login(req,resp);
		}
	}

	private void g_login(HttpServletRequest req, HttpServletResponse resp) {
		String g_name=req.getParameter("uname");
		String g_pass=req.getParameter("upass");
		String mm=DaoFactory.teacherDaoimp().teaInfo(g_name).getT_zhiwu();
		String add=DaoFactory.teacherDaoimp().showRole(mm).getA();
		String del=DaoFactory.teacherDaoimp().showRole(mm).getD();
		
		String upd=DaoFactory.teacherDaoimp().showRole(mm).getU();
		String sel=DaoFactory.teacherDaoimp().showRole(mm).getS();
		boolean flag=DaoFactory.GuanliDaoimp().g_login(g_name, g_pass);
		
		String path="";
		if(flag){
			path="main.html";
			req.getSession().setAttribute("login_name",g_name);
			req.getSession().setAttribute("mm", mm);
			req.getSession().setAttribute("add", add);
			req.getSession().setAttribute("del",del);
			req.getSession().setAttribute("upd",upd);
			req.getSession().setAttribute("sel",sel);
		}else{
			path="login.jsp";
			req.setAttribute("error_info", "登录失败");
		}
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
