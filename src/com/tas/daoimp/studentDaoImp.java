package com.tas.daoimp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.tas.TasSQL.TasSQL;
import com.tas.dao.Studentdao;
import com.tas.vo.Student;
import com.tas.vo.Teacher;
import com.tas.vo.danke_geade;
import com.tas.vo.grade;
import com.tas.vo.jiaoshi;
import com.tas.vo.xuanke;


public class studentDaoImp implements Studentdao{
	PreparedStatement pstm=null;
	public List<Student> findAllStu() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<Student> studs=new ArrayList<Student>();
		
			 sql="select * from student";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				Student student=new Student();
				student.setS_img(rs.getString(2));
				student.setS_id(rs.getString(3));
				student.setS_pass(rs.getString(4));
				student.setS_name(rs.getString(5));
				student.setS_sex(rs.getString(6));
				student.setS_age(rs.getString(7));
				student.setS_time(rs.getString(8));
				student.setS_address(rs.getString(9));
				student.setS_phoneNum(rs.getString(10));
				student.setS_birthday(rs.getString(11));
				student.setS_banji(rs.getString(12));
				studs.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studs;
		
	}
	public List<Student> selAllTea() {
		return null;
	}
	public List<grade> gradeAllTea() {
		return null;
	}
	public List<jiaoshi> jiaoshiAllTea() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Teacher> teacherAllTea() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<danke_geade> dankeAllTea() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<xuanke> xuankeAllTea() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<xuanke> xuanke1AllTea() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<xuanke> selectke() {
		// TODO Auto-generated method stub
		return null;
	}
	public int regist(xuanke user) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delSelectClass(String ct_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	public List g_login(String s_id, String s_pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
