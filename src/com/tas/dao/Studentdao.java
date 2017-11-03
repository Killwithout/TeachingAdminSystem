package com.tas.dao;

import java.util.List;

import com.tas.vo.Student;
import com.tas.vo.danke_geade;
import com.tas.vo.grade;
import com.tas.vo.jiaoshi;
import com.tas.vo.Teacher;
import com.tas.vo.xuanke;

public interface Studentdao {
	//显示所有信息
	public List<Student> selAllTea();
	//显示成绩
	public List<grade> gradeAllTea();
	//显示教室
	public List<jiaoshi> jiaoshiAllTea();
	//显示教师
	public  List<Teacher> teacherAllTea();
	//显示单科成绩
	public  List<danke_geade> dankeAllTea();
	//显示选课
	public 	List<xuanke> xuankeAllTea();
	//显示选课表
	public 	List<xuanke> xuanke1AllTea();
	
	public List<xuanke> selectke();
	//插入数据
	public int regist(xuanke user);
	//删除
	public int delSelectClass(String ct_id);
	
	public List g_login(String s_id,String s_pass);
}
