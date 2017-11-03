package com.tas.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.tas.TasSQL.TasSQL;

public class escServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String struts=req.getParameter("fangke");
		
		try {
    		if((Integer)getServletContext().getAttribute("count")!=null){
    			int i=(Integer)getServletContext().getAttribute("count");
    			getServletContext().setAttribute("count", i=i-1);
    		}else{
    			getServletContext().setAttribute("count",1);
    		}
	    	req.getRequestDispatcher("login.jsp").forward(req,resp);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
