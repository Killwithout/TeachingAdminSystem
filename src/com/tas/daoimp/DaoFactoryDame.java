package com.tas.daoimp;

import com.tas.dao.TeacherDaoDame;

public class DaoFactoryDame {
	//��ʦ�Ľӿڼ�ʵ�ֵĶ���
		public static TeacherDaoDame getTeacherDao(){
			TeacherDaoDame  userDao=new teacherDaoimpDame();
			return userDao;
		}
}
