package com.tas.dao;

import java.util.List;

import com.tas.vo.StudentDame;
import com.tas.vo.TeacherDame;
import com.tas.vo.danke_geadeDame;
import com.tas.vo.gradeDame;

public interface TeacherDaoDame {
	//��ʦ��¼ҳ��
	public List g_login(String t_id,String t_pass);
	//��ʾ������Ϣ
	public List<TeacherDame> selaTeacher(String teacherId);
	//���ѧ���ɼ�
	public int addgrade(gradeDame grade);
	//ɾ���ɼ�
	public int delGrade(String[] choos);
	//��ȡ������Ϣ
	public TeacherDame updTeac(String  t_id);
	//���Ƹ�����Ϣ
	public int updateTeac(TeacherDame teacher);
	//��ʾ���гɼ�
	public List<gradeDame> selAllgra();
	//���Ƴɼ�
	public  List<danke_geadeDame> dankeAllTea();
	//��ȡ�ɼ�
	public gradeDame getgrade(String [] s_id);
	//�޸ĳɼ�
	public gradeDame Update_grade(String  s_id);
	//��ʦ��ѯ
	public List<TeacherDame> selAllTeach();
	//��ʾѧ����Ϣ
	public List<StudentDame> selAllTea();
	//��ӽ�ʦ��Ϣ
	public int addTeacher(TeacherDame teacher);
}
