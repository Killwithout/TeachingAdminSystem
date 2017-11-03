package com.tas.dao;

import java.util.List;

import com.tas.vo.Student;
import com.tas.vo.danke_geade;
import com.tas.vo.grade;
import com.tas.vo.jiaoshi;
import com.tas.vo.Teacher;
import com.tas.vo.xuanke;

public interface Studentdao {
	//��ʾ������Ϣ
	public List<Student> selAllTea();
	//��ʾ�ɼ�
	public List<grade> gradeAllTea();
	//��ʾ����
	public List<jiaoshi> jiaoshiAllTea();
	//��ʾ��ʦ
	public  List<Teacher> teacherAllTea();
	//��ʾ���Ƴɼ�
	public  List<danke_geade> dankeAllTea();
	//��ʾѡ��
	public 	List<xuanke> xuankeAllTea();
	//��ʾѡ�α�
	public 	List<xuanke> xuanke1AllTea();
	
	public List<xuanke> selectke();
	//��������
	public int regist(xuanke user);
	//ɾ��
	public int delSelectClass(String ct_id);
	
	public List g_login(String s_id,String s_pass);
}
