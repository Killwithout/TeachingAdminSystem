package com.tas.servlet;

import java.io.IOException;
import java.util.List;

import javax.faces.application.Application;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.tas.daoimp.DaoFactoryDame;
import com.tas.util.AcessDame;
import com.tas.vo.StudentDame;
import com.tas.vo.TeacherDame;
import com.tas.vo.danke_geadeDame;
import com.tas.vo.gradeDame;

public class teacherServletDame extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String struts=req.getParameter("struts");
		
		//System.out.println("$$$$$$$$$$$$$" + struts);
		//req.getSession().setAttribute("teacherId",teacherId);
		 if(struts.equals("do_login")){
			g_login(req,resp);
		}else if(struts.equals("dAllTea")){
			findAllTea(req,resp);
		}else if(struts.equals("addgrade")){
			addgrade(req,resp);
		}else if(struts.equals("delTeacher")){
			delgrade(req,resp);
		}else if(struts.equals("updTeacher")){
			updTeacher(req,resp);
		}else if(struts.equals("Allgrade")){
			Allgrade(req,resp);
		}else if(struts.equals("dangreade")){
			do_findalldanke(req,resp);
		}else if(struts.equals("Update_grade")){
			Update_grade(req,resp);
		}else if(struts.equals("teacherup")){
			teacherup(req,resp);
		}else if(struts.equals("studentfindAllTea")){
			do_findAllstudent(req,resp);
		}else if(struts.equals("addTeacher")){
			addTeacher(req,resp);
		}
			
		}

	//修改个人信息
	private void teacherup(HttpServletRequest req, HttpServletResponse resp) {
		List<TeacherDame> teac=DaoFactoryDame.getTeacherDao().selAllTeach();
		req.setAttribute("teac",teac);
		String path="gerenTeacher.jsp";
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//修改成绩
	private void Update_grade(HttpServletRequest req, HttpServletResponse resp) {
		String [] chos= req.getParameterValues("choose");
		gradeDame gr=DaoFactoryDame.getTeacherDao().getgrade(chos);
		req.setAttribute("grade", gr);
		try {
			req.getRequestDispatcher("addgrade.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//个人成绩
	private void do_findalldanke(HttpServletRequest req,
			HttpServletResponse resp) {
		List<danke_geadeDame> danke_geade=DaoFactoryDame.getTeacherDao().dankeAllTea();
		String path="dangreade.jsp";
		req.setAttribute("danke_geade", danke_geade);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	//所有成绩
	private void Allgrade(HttpServletRequest req, HttpServletResponse resp) {
		List<gradeDame> grade=DaoFactoryDame.getTeacherDao().selAllgra();
		req.setAttribute("grade",grade);
		String path="Allgrade.jsp";
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//教师登录
	private void g_login(HttpServletRequest req, HttpServletResponse resp) {
		String t_id=req.getParameter("login_name");
		String t_pass=req.getParameter("login_pass");
		List list=DaoFactoryDame.getTeacherDao().g_login(t_id, t_pass);
		
		String path="";
		if(list.size()==2){
			path="main.html";
			req.getSession().setAttribute("login_name",t_id);
			req.getSession().setAttribute("imgName",list.get(0));
		}else{
			path="login.jsp";
			req.setAttribute("error_info", "鐧诲綍澶辫触");
		}
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//
	private void updTeacher(HttpServletRequest req, HttpServletResponse resp) {
		String choo=req.getParameter("choose");
		TeacherDame teacs=DaoFactoryDame.getTeacherDao().updTeac(choo);
		req.setAttribute("teacs", teacs);
		
		try {
			req.getRequestDispatcher("updTeac.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//删除成绩信息
	private void delgrade(HttpServletRequest req, HttpServletResponse resp) {
		String [] choos=req.getParameterValues("choose");
		int num=DaoFactoryDame.getTeacherDao().delGrade(choos);
		if(num>0){
			try {
				req.getRequestDispatcher("teachers?struts=Allgrade").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	//添加成绩
	private void addgrade(HttpServletRequest req, HttpServletResponse resp) {
		String s_id=req.getParameter("s_id");
		String ct_id=req.getParameter("ct_id");
		String g_fenshu=req.getParameter("g_fenshu");
		gradeDame gr=new gradeDame();
		gr.setS_id(s_id);
		gr.setCt_id(ct_id);
		gr.setG_fenshu(g_fenshu);
		int num=DaoFactoryDame.getTeacherDao().addgrade(gr);
		String path="";
		if(num>0){
			path="teachers?struts=Allgrade";
		}else{
			path="addgrade.jsp";
			req.setAttribute("errorinfo", AcessDame.ADD_Book_INFO);
		}
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}

	//教师个人信息
	private void findAllTea(HttpServletRequest req, HttpServletResponse resp) {
		String teacherId=(String)req.getSession().getAttribute("login_name");
		List<TeacherDame> teacs=DaoFactoryDame.getTeacherDao().selaTeacher(teacherId);
		req.setAttribute("teacs",teacs);
		String path="righteacher.jsp";
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//所有学生
	private void do_findAllstudent(HttpServletRequest req, HttpServletResponse resp) {
		List<StudentDame> student=DaoFactoryDame.getTeacherDao().selAllTea();
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
	
	//添加教师信息
		private void addTeacher(HttpServletRequest req, HttpServletResponse resp) {
			String t_img=req.getParameter("t_img");
			String t_id=req.getParameter("t_id");
			String t_name=req.getParameter("t_name");
			String t_sex=req.getParameter("t_sex");
			String t_age=req.getParameter("t_age");
			String t_time=req.getParameter("t_time");
			String t_address=req.getParameter("t_address");
			String t_phoneNum=req.getParameter("t_phoneNum");
			String t_birthday=req.getParameter("t_birthday");
			String t_about=req.getParameter("t_about");
			TeacherDame teacher=new TeacherDame();
			teacher.setT_img(t_img);
			teacher.setT_id(t_id);
			teacher.setT_name(t_name);
			teacher.setT_sex(t_sex);
			teacher.setT_age(t_age);
			teacher.setT_time(t_time);
			teacher.setT_address(t_address);
			teacher.setT_phoneNum(t_phoneNum);
			teacher.setT_birthday(t_birthday);
			teacher.setT_about(t_about);
			int num=DaoFactoryDame.getTeacherDao().addTeacher(teacher);
			String path="";
			if(num>0){
				path="teachers?struts=dAllTea";
			}else{
				path="addTeacher.jsp";
				req.setAttribute("errorinfo", AcessDame.ADD_Book_INFO);
			}
			try {
				req.getRequestDispatcher(path).forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
