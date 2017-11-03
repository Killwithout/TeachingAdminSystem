package com.tas.daoimp;

import com.tas.dao.TeacherDaoDame;

public class DaoFactoryDame {
	//教师的接口及实现的对象
		public static TeacherDaoDame getTeacherDao(){
			TeacherDaoDame  userDao=new teacherDaoimpDame();
			return userDao;
		}
}
