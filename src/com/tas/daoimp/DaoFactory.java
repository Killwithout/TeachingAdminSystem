package com.tas.daoimp;

import com.tas.dao.GuanliDao;
import com.tas.dao.Studentdao;
import com.tas.dao.TeacherDao;
import com.tas.dao.ShowVideo;

public class DaoFactory {
	
	public static GuanliDao GuanliDaoimp(){
		GuanliDao guanliDao=new GuanliDaoimp();
		return guanliDao;
		
	}
	public static TeacherDao teacherDaoimp(){
		TeacherDao teacherDao=new teacherDaoimp();
		return teacherDao;
		
	}
	public static Studentdao studentDaoImp(){
		Studentdao studentDao=new studentDaoImp();
		return studentDao;
		
	}

}
