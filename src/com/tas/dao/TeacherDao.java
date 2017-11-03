package com.tas.dao;

import java.util.List;

import com.tas.vo.Role;
import com.tas.vo.Teacher;

public interface TeacherDao {
	public List<Teacher> selAllTea();
	public int addTeacher(Teacher teacher);
	public int delTeacher(String[] choos);
	public Teacher updTeac(String [] t_id);
	public int updateTeac(Teacher teacher);
	public List<Role> show_role();
	public int updateRole(Role role);
	public int updateUserRole(String t_id,String role_id);
	
	public Role showRole(String role_id);
	public List<Teacher> showRoleAll ();
	
	public Teacher teaInfo(String t_id);
	
	public int addRole(Role role);
	public int delRole(String  r_id);
	
}
