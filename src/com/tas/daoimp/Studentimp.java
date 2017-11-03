package com.tas.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tas.TasSQL.TasSQL;
import com.tas.dao.Studentdao;
import com.tas.vo.Student;
import com.tas.vo.Teacher;
import com.tas.vo.danke_geade;
import com.tas.vo.grade;
import com.tas.vo.jiaoshi;
import com.tas.vo.shanchu;
import com.tas.vo.xuanke;



public class Studentimp implements Studentdao{
	PreparedStatement pstm=null;
	
	//显示所有信息
		public List<Student> selAllTea() {
			Connection conn= TasSQL.getConnection();
			String sql="";
			List<Student> Students=new ArrayList<Student>();
			
				 sql="select * from Student where s_id=?";
			
			try {
				pstm=conn.prepareStatement(sql);
				
				ResultSet rs=pstm.executeQuery();
				System.out.println("***selAllTea*********");
				while(rs.next()){
					Student Student=new Student();
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
	
	//显示成绩信息
	public List<grade> gradeAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<grade> grade=new ArrayList<grade>();
		
			 sql="select * from grade";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				grade grad=new grade();
				grad.setCt_id(rs.getString(3));
				grad.setG_fenshu(rs.getString(4));
				grade.add(grad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}
	
	//显示教室信息
	public List<jiaoshi> jiaoshiAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<jiaoshi> jiaoshi=new ArrayList<jiaoshi>();
		
			 sql="select * from classroom";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				jiaoshi js=new jiaoshi();
				js.setCr_id(rs.getString(2));
				js.setCr_name(rs.getString(3));
				jiaoshi.add(js);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jiaoshi;
	}
	//显示教师信息
	public List<Teacher> teacherAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<Teacher> teacher=new ArrayList<Teacher>();
		
			 sql="select * from classTable";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				Teacher tc=new Teacher();	
				tc.setCt_name(rs.getString(3));
				tc.setCt_teacher_name(rs.getString(4));
				teacher.add(tc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	public List<danke_geade> dankeAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<danke_geade> danke_geade=new ArrayList<danke_geade>();
		
			 sql="select * from student,grade where s_name='陈科' ";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				danke_geade dk=new danke_geade();	
				dk.setS_name(rs.getString(4));
				dk.setCt_id(rs.getString(14));
				dk.setG_fenshu(rs.getString(15));
				danke_geade.add(dk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danke_geade;
	}
	public List<xuanke> xuankeAllTea() {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<xuanke> xuanke=new ArrayList<xuanke>();
		
			 sql="select ct_id,ct_name,ct_teacher_name,ct_jieshao from car;";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				xuanke xk=new xuanke();	
				xk.setCt_id(rs.getString(1));
				xk.setCt_name(rs.getString(2));
				xk.setCt_teacher_name(rs.getString(3));
				xk.setCt_jieshao(rs.getString(4));
				xuanke.add(xk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xuanke;
	}

	public List<xuanke> xuanke1AllTea() {
		/**	Connection conn= TasSQL.getConnection();
		String sql="";
		List<xuanke> xuanke=new ArrayList<xuanke>();
		
			 sql="select ct_id,ct_name,ct_teacher_name,ct_jieshao from car1 ";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
	while(rs.next()){
				xuanke xk=new xuanke();	
				xk.setCt_id(rs.getString(1));
				xk.setCt_name(rs.getString(2));
				xk.setCt_teacher_name(rs.getString(3));
				xk.setCt_jieshao(rs.getString(4));
				xuanke.add(xk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}**/
		return null;
	}
	public int regist(xuanke user) {
		Connection connection= TasSQL.getConnection();
		int flag=0;
		String sql="insert into car1 values(?,?,?,?);";
			
			try {
				PreparedStatement pstm= connection.prepareStatement(sql);
				pstm.setString(2, user.getCt_id());
				pstm.setString(3, user.getCt_name());
				pstm.setString(4, user.getCt_teacher_name());
				pstm.setString(5, user.getCt_jieshao());
				flag =pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return flag;
		
		
	}
	
	public List g_login(String s_id, String s_pass) {
		List list=new ArrayList();
		Connection conn= TasSQL.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		boolean flag=false;
		String pathString="";
		String sql="select s_id,s_img from student where s_id=? and s_pass=?";
				try {
					pstm=conn.prepareStatement(sql);
					pstm.setString(1, s_id);
					pstm.setString(2, s_pass);
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

	
	
	public List<xuanke> xuankeAllTea(String id) {
		Connection conn= TasSQL.getConnection();
		String sql="";
		List<xuanke> xuanke=new ArrayList<xuanke>();
		
			 sql="select * from car where ct_id=?";
		
		try {
			pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				xuanke xk=new xuanke();	
				xk.setCt_id(rs.getString(2));
				xk.setCt_name(rs.getString(3));
				xk.setCt_teacher_name(rs.getString(4));
				xk.setCt_jieshao(rs.getString(5));
				xuanke.add(xk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xuanke;
	}
	public int delSelectClass(String ct_id) {
		Connection conn= TasSQL.getConnection();
		String sql="delete from car1 where ct_id=?";
		int tianshou=0;
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, ct_id);
				tianshou=pstm.executeUpdate();
				System.out.println("****imp********"+tianshou);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return tianshou;
	}
	public List<xuanke> selectke() {
		// TODO Auto-generated method stub
		return null;
	}
}

