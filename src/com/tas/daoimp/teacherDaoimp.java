package com.tas.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tas.TasSQL.TasSQL;
import com.tas.dao.TeacherDao;
import com.tas.vo.Role;
import com.tas.vo.Teacher;

public class teacherDaoimp implements TeacherDao{
	PreparedStatement pstm=null;
	public List<Teacher> selAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<Teacher> teachers=new ArrayList<Teacher>();
		
			 sql="select * from teacher";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				Teacher teacher=new Teacher();
				teacher.setT_img(rs.getString(2));
				teacher.setT_id(rs.getString(3));
				teacher.setT_pass(rs.getString(4));
				teacher.setT_name(rs.getString(5));
				teacher.setT_sex(rs.getString(6));
				teacher.setT_age(rs.getString(7));
				teacher.setT_time(rs.getString(8));
				teacher.setT_address(rs.getString(9));
				teacher.setT_phoneNum(rs.getString(10));
				teacher.setT_birthday(rs.getString(11));
				teacher.setT_zhiwu(rs.getString(12));
				teachers.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}
	public int addTeacher(Teacher teacher) {
		
		
			Connection conn= TasSQL.getConnection();
			String sqlString="insert into teacher values(?,?,123456,?,?,?,?,?,?,?,?) ";
			int num=0;
			try {
				pstm= conn.prepareStatement(sqlString);
				pstm.setString(1, teacher.getT_img());
				pstm.setString(2, teacher.getT_id());
				pstm.setString(3, teacher.getT_name());
				pstm.setString(4, teacher.getT_sex());
				pstm.setString(5,teacher.getT_age());
				
				pstm.setString(6,teacher.getT_time());
				pstm.setString(7,teacher.getT_address());
				pstm.setString(8,teacher.getT_phoneNum());
				pstm.setString(9, teacher.getT_birthday());
				
				pstm.setString(10, teacher.getT_zhiwu());
				num =pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return num;
			
		}
	public int delTeacher(String[] choos) {
		Connection conn= TasSQL.getConnection();
		String sql="delete from teacher where t_id=?";
		int num=0;
		for(int i=0;i<choos.length;i++){
			String book_id=choos[i];
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, book_id);
				num=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}
	
	
	
	public Teacher updTeac(String[] t_id) {
		Connection conn= TasSQL.getConnection();
		Teacher teacher=new Teacher();
		String sql="select * from teacher where t_id=?";
		try {
			pstm=conn.prepareStatement(sql);
			if(t_id[0]!=null&&!"".equals(t_id[0])){
				pstm.setString(1, t_id[0]);
				
			}
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				
				teacher.setT_img(rs.getString(2));
				teacher.setT_id(rs.getString(3));
				teacher.setT_pass(rs.getString(4));
				teacher.setT_name(rs.getString(5));
				teacher.setT_sex(rs.getString(6));
				teacher.setT_age(rs.getString(7));
				teacher.setT_time(rs.getString(8));
				teacher.setT_address(rs.getString(9));
				teacher.setT_phoneNum(rs.getString(10));
				teacher.setT_birthday(rs.getString(11));
				teacher.setT_zhiwu(rs.getString(12));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	public int updateTeac(Teacher teacher) {
		Connection conn= TasSQL.getConnection();
		
		String sql="update teacher set t_img=?,t_name=?,t_sex=?,t_age=?,t_time=?,t_address=?,t_phoneNum=? ,t_birthday=?,t_zhiwu=? where t_id=?";
		int num=0;
		try {
			pstm= conn.prepareStatement(sql);
			
			pstm.setString(1, teacher.getT_img());
			
			
			pstm.setString(2, teacher.getT_name());
			pstm.setString(3, teacher.getT_sex());
			pstm.setString(4,teacher.getT_age());
			
			pstm.setString(5,teacher.getT_time());
			pstm.setString(6,teacher.getT_address());
			pstm.setString(7,teacher.getT_phoneNum());
			pstm.setString(8, teacher.getT_birthday());
			
			pstm.setString(9, teacher.getT_zhiwu());
			pstm.setString(10, teacher.getT_id());
			num =pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	public List<Role> show_role() {
		List<Role> rlist = new ArrayList<Role>();
		String sql = "select * from t_role";
		Connection connection = TasSQL.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRole_idString(rs.getString(1));
				role.setRole_nameString(rs.getString(2));
				role.setA(rs.getString(3));
				role.setD(rs.getString(4));
				role.setU(rs.getString(5));
				role.setS(rs.getString(6));
				rlist.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rlist;
	}
	public int updateRole(Role role) {
		String sqlString="update t_role set a='"+role.getA()+"',d='"+role.getD()+"',u='"+role.getU()+"',s='"+role.getS()+"' where id="+role.getRole_idString();
		Connection connection = TasSQL.getConnection();
		int flag = 0;
		try {
			System.out.println(sqlString);
			Statement pstm = connection.createStatement();
			flag = pstm.executeUpdate(sqlString);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public int updateUserRole(String t_id, String role_id) {
		
		
		String sqlString="update teacher set t_zhiwu=? where t_id=?";
		Connection connection = TasSQL.getConnection();
		int flag = 0;
		try {
			PreparedStatement pstm = connection.prepareStatement(sqlString);
			
			pstm.setString(1, role_id);
			pstm.setString(2, t_id);
			flag = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public Role showRole(String role_id) {
		
		String sql = "select * from t_role where id=?";
		Role role=new Role();
		Connection connection = TasSQL.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, role_id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
			role.setRole_idString(rs.getString(1));
			role.setRole_nameString(rs.getString(2));
			role.setA(rs.getString(3));
			role.setD(rs.getString(4));
			role.setU(rs.getString(5));
			role.setS(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	public List<Teacher> showRoleAll() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<Teacher> teachers=new ArrayList<Teacher>();
		
			 sql="SELECT t_id,t_name,t_sex,t_age,t_class_name FROM teacher,t_role where teacher.t_zhiwu=t_role.id";

		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				Teacher teacher=new Teacher();
				
				teacher.setT_id(rs.getString(1));
				
				teacher.setT_name(rs.getString(2));
				teacher.setT_sex(rs.getString(3));
				teacher.setT_age(rs.getString(4));
				teacher.setT_Manger(rs.getString(5));
				teachers.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}
	public Teacher teaInfo(String t_id) {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<Teacher> teachers=new ArrayList<Teacher>();
		
			 sql="SELECT * FROM teacher where t_id=?";

		Teacher teacher=null;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, t_id);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				teacher=new Teacher();
				
				teacher.setT_img(rs.getString(2));
				teacher.setT_id(rs.getString(3));
				teacher.setT_pass(rs.getString(4));
				teacher.setT_name(rs.getString(5));
				teacher.setT_sex(rs.getString(6));
				teacher.setT_age(rs.getString(7));
				teacher.setT_time(rs.getString(8));
				teacher.setT_address(rs.getString(9));
				teacher.setT_phoneNum(rs.getString(10));
				teacher.setT_birthday(rs.getString(11));
				teacher.setT_zhiwu(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	public int addRole(Role role) {
		Connection conn= TasSQL.getConnection();
		String sqlString="insert into t_role values(9,?,?,?,?,?) ";
		int num=0;
		try {
			pstm= conn.prepareStatement(sqlString);
			pstm.setString(1, role.getRole_nameString());
			pstm.setString(2, role.getA());
			pstm.setString(3, role.getD());
			pstm.setString(4, role.getU());
			pstm.setString(5,role.getS());
		num =pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
	}
	public int delRole(String r_id) {
		Connection conn= TasSQL.getConnection();
		String sql="delete from t_role where id=?";
		int num=0;
		
			
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, r_id);
				num=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return num;

	}
	
	
}


