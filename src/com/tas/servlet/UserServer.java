package com.tas.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tas.daoimp.DaoFactory;


public class UserServer {
	private void findallbook(HttpServletRequest req, HttpServletResponse resp) {
		String pathString="";
		Map<String, Object>books=null;
		
			String findword=req.getParameter("ding");
			pathString="book_list.jsp";
			/*map.put("maxPage", maxPage);
			map.put("curPage", curPage);
			map.put("list", list);*/
			req.setAttribute("maxPage", books.get("maxPage"));
			req.setAttribute("curPage", books.get("curPage"));
			req.setAttribute("list", books.get("list"));
		
		try {
			req.getRequestDispatcher(pathString).forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
