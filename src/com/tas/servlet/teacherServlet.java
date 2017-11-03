package com.tas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tas.daoimp.DaoFactory;
import com.tas.util.Option;
import com.tas.vo.Role;
import com.tas.vo.Teacher;

public class teacherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String struts=req.getParameter("struts");
		if(struts.equals("findAllTea")){
			
			findAllTea(req,resp);
		}else if(struts.equals("addTeacher")){
			addTeacher(req,resp);
		}else if(struts.equals("delTeacher")){
			delTeacher(req,resp);
		}else if(struts.equals("updTeacher")){
			updTeacher(req,resp);
		}else if(struts.equals("updateTeacher")){
			updateTeacher(req,resp);
		}else if(struts.equals("sheTeacher")){
			sheTeacher(req,resp);
		}else if(struts.equals("show_role")){
			show_role(req,resp);
		}else if(struts.equals("saveRoleOption")){
			saveRoleOption(req,resp);
		}else if(struts.equals("showRoleAll")){
			showRoleAll(req,resp);
		}else if(struts.equals("saveRole")){
			saveRole(req,resp);
		}else if(struts.equals("addRole")){
			addRole(req,resp);
		}else if(struts.equals("delRole")){
			delRole(req,resp);
		}
	}

	private void delRole(HttpServletRequest req, HttpServletResponse resp) {
		
		
		String role=req.getParameter("role_iid");
		
		int num=DaoFactory.teacherDaoimp().delRole(role);
		if(num>0){
			try {
				req.getRequestDispatcher("teacher?struts=show_role").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void addRole(HttpServletRequest req, HttpServletResponse resp) {
		String r_name=req.getParameter("r_name");
		Role role = new Role();
		String[] option = req.getParameterValues("option");
		if(option!=null){
			for (String string : option) {
				if ("a".equals(string)) {
					role.setA("checked='a'");
				} else if ("d".equals(string)) {
					role.setD("checked='d'");
				} else if ("u".equals(string)) {
					role.setU("checked='u'");
				} else if ("s".equals(string)) {
					role.setS("checked='s'");
				} 
			}
		}
		role.setRole_nameString(r_name);
		int num=DaoFactory.teacherDaoimp().addRole(role);
		if(num>0){
			try {
				req.getRequestDispatcher("teacher?struts=show_role").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
												
	}

	private void saveRole(HttpServletRequest req, HttpServletResponse resp) {
		String role_id = req.getParameter("roleselect");
		
		String t_id=req.getParameter("t_id");
		int num=DaoFactory.teacherDaoimp().updateUserRole(t_id, role_id);
		Role role=DaoFactory.teacherDaoimp().showRole(role_id);
		List<Teacher> teacs=DaoFactory.teacherDaoimp().showRoleAll();
		req.setAttribute("role", role);
		req.setAttribute("teacs", teacs);
		
		try {
			req.getRequestDispatcher("showRoleAll.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void showRoleAll(HttpServletRequest req, HttpServletResponse resp) {
		List<Teacher> teacs=DaoFactory.teacherDaoimp().showRoleAll();
		
		
		String path="showRoleAll.jsp";
		req.setAttribute("teacs", teacs);
		
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

	private void saveRoleOption(HttpServletRequest req, HttpServletResponse resp) {
		String role_id=req.getParameter("role_id");
		String [] options={"","","",""};
		
		String [] op=req.getParameterValues("op");
		if(op!=null){
			for(String ops:op){
				if(ops.equals("checked=a")){
					options[0]="checked=a";
				}
				if(ops.equals("checked=d")){
					options[1]="checked=d";
				}
				if(ops.equals("checked=u")){
					options[2]="checked=u";
				}
				if(ops.equals("checked=s")){
					options[3]="checked=s";
				}
			}
		}
		Role role=new Role();
		role.setRole_idString(role_id);
		if(!"".equals(options[0])){
			role.setA(options[0]);
		}
		if(!"".equals(options[1])){
			role.setD(options[1]);
		}
		if(!"".equals(options[2])){
			role.setU(options[2]);
		}
		if(!"".equals(options[3])){
			role.setS(options[3]);
		}
		DaoFactory.teacherDaoimp().updateRole(role);
		show_role(req,resp);
	}

	private void show_role(HttpServletRequest req, HttpServletResponse resp) {
		List<Role> rlist=DaoFactory.teacherDaoimp().show_role();
		req.setAttribute("roles", rlist);
		try {
			req.getRequestDispatcher("role_list.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sheTeacher(HttpServletRequest req, HttpServletResponse resp) {
		String [] choo=req.getParameterValues("choose");
		
		Teacher teac=DaoFactory.teacherDaoimp().updTeac(choo);
		List<Role> roles = DaoFactory.teacherDaoimp().show_role();
		
		req.setAttribute("teac", teac);
		req.setAttribute("roles", roles);
		try {
			req.getRequestDispatcher("she.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void updateTeacher(HttpServletRequest req, HttpServletResponse resp) {
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
		Teacher teacher=new Teacher();
		teacher.setT_img(t_img);
		teacher.setT_id(t_id);
		teacher.setT_name(t_name);
		teacher.setT_sex(t_sex);
		teacher.setT_age(t_age);
		teacher.setT_time(t_time);
		teacher.setT_address(t_address);
		teacher.setT_phoneNum(t_phoneNum);
		teacher.setT_birthday(t_birthday);
		teacher.setT_zhiwu(t_about);
		int num=DaoFactory.teacherDaoimp().updateTeac(teacher);
		if(num>0){
			try {
				req.getRequestDispatcher("teacher?struts=findAllTea").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void updTeacher(HttpServletRequest req, HttpServletResponse resp) {
		String [] choo=req.getParameterValues("choose");
		Teacher teac=DaoFactory.teacherDaoimp().updTeac(choo);
		req.setAttribute("teac", teac);
		
		try {
			req.getRequestDispatcher("updTeac.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void delTeacher(HttpServletRequest req, HttpServletResponse resp) {
		String [] choos=req.getParameterValues("choose");
		int num=DaoFactory.teacherDaoimp().delTeacher(choos);
		if(num>0){
			try {
				req.getRequestDispatcher("teacher?struts=findAllTea").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

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
		Teacher teacher=new Teacher();
		teacher.setT_img(t_img);
		teacher.setT_id(t_id);
		teacher.setT_name(t_name);
		teacher.setT_sex(t_sex);
		teacher.setT_age(t_age);
		teacher.setT_time(t_time);
		teacher.setT_address(t_address);
		teacher.setT_phoneNum(t_phoneNum);
		teacher.setT_birthday(t_birthday);
		teacher.setT_zhiwu(t_about);
		int num=DaoFactory.teacherDaoimp().addTeacher(teacher);
		String path="";
		if(num>0){
			path="teacher?struts=findAllTea";
		}else{
			path="addTeacher.jsp";
			req.setAttribute("errorinfo", Option.ADD_Book_INFO);
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

	private void findAllTea(HttpServletRequest req, HttpServletResponse resp) {
		List<Teacher> teacs=DaoFactory.teacherDaoimp().selAllTea();
		
		
		String path="right.jsp";
		req.setAttribute("teacs", teacs);
		
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
