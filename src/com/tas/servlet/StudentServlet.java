package com.tas.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tas.TasSQL.TasSQL;
import com.tas.daoimp.DaoFactoryDame;
import com.tas.vo.Student;
import com.tas.vo.danke_geade;
import com.tas.vo.grade;
import com.tas.vo.jiaoshi;
import com.tas.vo.Teacher;
import com.tas.vo.xuanke;

public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String struts =req.getParameter("struts");
		System.out.println("***********"+struts);
		//String grade =req.getParameter("grade");
		if(struts.equals("do_login")){
			g_login(req,resp);
		}else if("findallstudent".equals(struts)){
			do_findAllstudent(req,resp);
		}else if("findallgrade".equals(struts)){
			do_findAllgrade(req,resp);
		}else if("findalljiaoshi".equals(struts)){
			do_findalljiaoshi(req,resp);
		}else if("findallteacher".equals(struts)){
			do_findallteacher(req,resp);
		}else if("findalldanke".equals(struts)){
			do_findalldanke(req,resp);
		}else if("findallxuanke".equals(struts)){
			do_findallxuanke(req,resp);
		}else if("findallxuanke1".equals(struts)){
			do_findallxuanke1(req,resp);
		}else if(struts.equals("add")){
			add(req,resp);
		}else if("delTeacher".equals(struts)){
			delSelectClass(req,resp);
		}
	}
	
	private void g_login(HttpServletRequest req, HttpServletResponse resp) {
		String s_id=req.getParameter("login_name");
		String s_pass=req.getParameter("login_pass");
		List list=DaoFactoryDame.getTeacherDao().g_login(s_id, s_pass);
		
		String path="";
		if(list.size()==2){
			path="main.html";
			req.getSession().setAttribute("login_name",s_id);
			req.getSession().setAttribute("imgName",list.get(0));
		}else{
			path="login.jsp";
			req.setAttribute("error_info", "登录失败");
		}
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delSelectClass(HttpServletRequest req, HttpServletResponse resp) {
		String ct_id=req.getParameter("id");
		int num=DaoFactory.getStudentdao().delSelectClass(ct_id);
		String rid="0";
		req.getSession().setAttribute("rid",rid);
		System.out.println("*******rid********"+rid);
		if(num>0){
			try {
				req.getRequestDispatcher("xuanke1.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		String ct_id=req.getParameter("id");
		String ct_name=req.getParameter("name");
		String ct_teacher_name=req.getParameter("t_name");
		String ct_jieshao=req.getParameter("jieshao");
		int eg=0;
		try {
			Connection conn= TasSQL.getConnection();
			String sql="insert into car1 values(?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, ct_id);
			pst.setString(2, ct_name);
			pst.setString(3, ct_teacher_name);
			pst.setString(4, ct_jieshao);
			
			pst.executeUpdate();
			
			String sql2="select ct_id,ct_name,ct_teacher_name,ct_jieshao from car1";
			Statement sts=conn.createStatement();
			ResultSet rs=sts.executeQuery(sql2);
			String ctid="";
			String ctname="";
			String ctteacher_name="";
			String ctjieshao="";
			while(rs.next()){
				ctid=rs.getString(1);
				ctname=rs.getString(2);
				ctteacher_name=rs.getString(3);
				ctjieshao=rs.getString(4);
			}
			String rid="1";
			req.getSession().setAttribute("rid", rid);
			req.getSession().setAttribute("ct_id", ctid);
			req.getSession().setAttribute("ct_name", ctname);
			req.getSession().setAttribute("ct_teacher_name", ctteacher_name);
			req.getSession().setAttribute("ct_jieshao", ctjieshao);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		String path="xuanke1.jsp";
		req.setAttribute("xuanke", ct_id);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void do_findallxuanke1(HttpServletRequest req,
			HttpServletResponse resp) {
		List<xuanke> xuanke=DaoFactory.getStudentdao().xuanke1AllTea();
		String path="xuanke1.jsp";
		req.setAttribute("xuanke", xuanke);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private void do_findallxuanke(HttpServletRequest req,
			HttpServletResponse resp) {
		List<xuanke> xuanke=DaoFactory.getStudentdao().xuankeAllTea();
		String path="xuanke.jsp";
		req.setAttribute("xuanke", xuanke);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void do_findalldanke(HttpServletRequest req,
			HttpServletResponse resp) {
		List<danke_geade> danke_geade=DaoFactory.getStudentdao().dankeAllTea();
		String path="danke.jsp";
		req.setAttribute("danke_geade", danke_geade);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void do_findallteacher(HttpServletRequest req,
			HttpServletResponse resp) {
		List<Teacher> teacher=DaoFactory.getStudentdao().teacherAllTea();
		String path="teacher.jsp";
		req.setAttribute("teacher", teacher);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void do_findalljiaoshi(HttpServletRequest req,
			HttpServletResponse resp) {
		List<jiaoshi> jiaoshi=DaoFactory.getStudentdao().jiaoshiAllTea();
		String path="JS_student.jsp";
		req.setAttribute("jiaoshi", jiaoshi);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void do_findAllgrade(HttpServletRequest req,HttpServletResponse resp) {
		List<grade> grade=DaoFactory.getStudentdao().gradeAllTea();
		String path="chengji_student.jsp";
		req.setAttribute("grade", grade);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	private void do_findAllstudent(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("**********");
		List<Student> student=DaoFactory.getStudentdao().selAllTea();
		String path="Student_gerenxinxi.jsp";
		req.setAttribute("student", student);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
