package com.tas.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tas.TasSQL.TasSQL;
import com.tas.dao.TeacherDaoDame;
import com.tas.vo.StudentDame;
import com.tas.vo.TeacherDame;
import com.tas.vo.danke_geadeDame;
import com.tas.vo.gradeDame;

public class teacherDaoimpDame implements TeacherDaoDame{
	PreparedStatement pstm=null;
	//鏄剧ず涓汉淇℃伅
	public List<TeacherDame> selaTeacher(String teacherId) {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<TeacherDame> teachers=new ArrayList<TeacherDame>();
		
			 sql="select * from teacher where t_id=?";
		
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, teacherId);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				TeacherDame teacher=new TeacherDame();
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
				teacher.setT_about(rs.getString(12));
				teachers.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}
	
	//添加成绩
	public int  addgrade(gradeDame grade) {
			Connection conn= TasSQL.getConnection();
			String sqlString="insert into grade values(?,?,?) ";
			int num=0;
			try {
				pstm= conn.prepareStatement(sqlString);
				pstm.setString(1, grade.getS_id());
				pstm.setString(2, grade.getCt_id());
				pstm.setString(3, grade.getG_fenshu());
				num =pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return num;
			
		}
	
		//删除成绩
	public int delGrade(String[] choos) {
		Connection conn= TasSQL.getConnection();
		String sql="delete from grade where s_id=?";
		int num=0;
		for(int i=0;i<choos.length;i++){
			String s_id=choos[i];
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, s_id);
				num=pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}
	
	//修改教师信息
	public TeacherDame updTeac(String t_id) {
		Connection conn= TasSQL.getConnection();
		TeacherDame teacher=new TeacherDame();
		String sql="select * from teacher where t_id=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, t_id);
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
				teacher.setT_about(rs.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	//修改教师信息
	public int updateTeac(TeacherDame teacher) {
		Connection conn=TasSQL.getConnection();
		
		String sql="insert into teacher values(?,?,123456,?,?,?,?,?,?,?,?)";
		int num=0;
		try {
			pstm= conn.prepareStatement(sql);
			pstm.setString(2, teacher.getT_img());
			pstm.setString(3, teacher.getT_id());
			pstm.setString(4, teacher.getT_name());
			pstm.setString(5, teacher.getT_sex());
			pstm.setString(6,teacher.getT_age());
			pstm.setString(7,teacher.getT_time());
			pstm.setString(8,teacher.getT_address());
			pstm.setString(9,teacher.getT_phoneNum());
			pstm.setString(10, teacher.getT_birthday());
			pstm.setString(11, teacher.getT_about());
			num =pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	//所有成绩
	public List<gradeDame> selAllgra() {
			Connection conn= TasSQL.getConnection();
			String sql="";
			List<gradeDame> grad=new ArrayList<gradeDame>();
			
				 sql="select * from grade,classTable where classTable.ct_name=grade.ct_id";
			
			try {
				pstm=conn.prepareStatement(sql);
				
				ResultSet rs=pstm.executeQuery();
				
				while(rs.next()){
					gradeDame gr=new gradeDame();
					gr.setS_id(rs.getString(2));
					gr.setCt_id(rs.getString(3));
					gr.setG_fenshu(rs.getString(4));
					gr.setCt_name(rs.getString(7));
					gr.setCt_teacher_name(rs.getString(8));
					grad.add(gr);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return grad;
	}
	//教师登录页面
	public List g_login(String t_id, String t_pass) {
		List list=new ArrayList();
		Connection conn= TasSQL.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		boolean flag=false;
		String pathString="";
		String sql="select t_id,t_img from teacher where t_id=? and t_pass=?";
				try {
					pstm=conn.prepareStatement(sql);
					pstm.setString(1, t_id);
					pstm.setString(2, t_pass);
					rs =pstm.executeQuery();
					
					while(rs.next()){
						pathString=rs.getString(2);
						flag=true;
						list.add(pathString);
						list.add(flag);
					}
					if(!flag)
					list.add(flag);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
		}

	//单科查询
	public List<danke_geadeDame> dankeAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<danke_geadeDame> danke_geade=new ArrayList<danke_geadeDame>();
		
			 sql="select * from student,grade where s_name='陈科'";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				danke_geadeDame dk=new danke_geadeDame();	
				dk.setS_name(rs.getString(5));
				dk.setCt_id(rs.getString(15));
				dk.setG_fenshu(rs.getString(16));
				danke_geade.add(dk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danke_geade;
	}
	
	
//成绩
	public gradeDame getgrade(String[] s_id) {
		Connection conn = TasSQL.getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		gradeDame gr = new gradeDame();
		String sql = "select * from grade where s_id=?";
		try {
			pstm = conn.prepareStatement(sql);
			if (null != s_id[0] && !"".equals(s_id[0])) {
				pstm.setString(1, s_id[0]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				gr.setS_id(rs.getString(2));
				gr.setCt_id(rs.getString(3));
				gr.setG_fenshu(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} 
		return gr;
	}

	//修改成绩
	public gradeDame Update_grade(String s_id) {
		Connection conn = TasSQL.getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		gradeDame gr = new gradeDame();
		String sql = "select * from grade where s_id=?";
		try {
			pstm = conn.prepareStatement(sql);
			if (null != s_id && !"".equals(s_id)) {
				pstm.setString(1, s_id);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				gr.setS_id(rs.getString(2));
				gr.setCt_id(rs.getString(3));
				gr.setG_fenshu(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} 
		return gr;
	}

	//教师信息
	public List<TeacherDame> selAllTeach() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<TeacherDame> teachers=new ArrayList<TeacherDame>();
		
			 sql="select * from teacher";
		
		try {
			pstm=conn.prepareStatement(sql);
			
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				TeacherDame teacher=new TeacherDame();
				teacher.setT_id(rs.getString(3));
				teacher.setT_name(rs.getString(5));
				teacher.setT_sex(rs.getString(6));
				teacher.setT_age(rs.getString(7));
				teacher.setT_time(rs.getString(8));
				teacher.setT_address(rs.getString(9));
				teacher.setT_phoneNum(rs.getString(10));
				teacher.setT_birthday(rs.getString(11));
				teacher.setT_about(rs.getString(12));
				teachers.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	//学生信息
	public List<StudentDame> selAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<StudentDame> Students=new ArrayList<StudentDame>();
		
			 sql="select * from Student";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				StudentDame Student=new StudentDame();
				//Student.setS_img(rs.getString(2));
				Student.setS_id(rs.getString(3));
				Student.setS_name(rs.getString(4));
				Student.setS_sex(rs.getString(5));
				Student.setS_age(rs.getString(6));
				Student.setS_time(rs.getString(7));
				Student.setS_phoneNum(rs.getString(8));
				Student.setS_address(rs.getString(9));
				Student.setS_birthday(rs.getString(10));
				Student.setS_banji(rs.getString(11));
				Students.add(Student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Students;
	}
	//添加教师信息
		public int addTeacher(TeacherDame teacher) {
			
			
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
					pstm.setString(10, teacher.getT_about());
					num =pstm.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return num;
			}
	
}



