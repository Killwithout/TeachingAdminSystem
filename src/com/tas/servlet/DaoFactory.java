package com.tas.servlet;

import com.tas.dao.Studentdao;
import com.tas.daoimp.Studentimp;

public class DaoFactory {
	public static Studentdao getStudentdao(){
		Studentdao  st=new Studentimp();
		return st;
	}

}
