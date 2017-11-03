package com.tas.dao;

import java.util.List;

import com.tas.vo.StudentDame;
import com.tas.vo.TeacherDame;
import com.tas.vo.danke_geadeDame;
import com.tas.vo.gradeDame;

public interface TeacherDaoDame {
	//教师登录页面
	public List g_login(String t_id,String t_pass);
	//显示个人信息
	public List<TeacherDame> selaTeacher(String teacherId);
	//添加学生成绩
	public int addgrade(gradeDame grade);
	//删除成绩
	public int delGrade(String[] choos);
	//获取个人信息
	public TeacherDame updTeac(String  t_id);
	//完善个人信息
	public int updateTeac(TeacherDame teacher);
	//显示所有成绩
	public List<gradeDame> selAllgra();
	//单科成绩
	public  List<danke_geadeDame> dankeAllTea();
	//获取成绩
	public gradeDame getgrade(String [] s_id);
	//修改成绩
	public gradeDame Update_grade(String  s_id);
	//教师查询
	public List<TeacherDame> selAllTeach();
	//显示学生信息
	public List<StudentDame> selAllTea();
	//添加教师信息
	public int addTeacher(TeacherDame teacher);
}
