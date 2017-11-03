package com.tas.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tas.TasSQL.TasSQL;

public class FengYeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.dofengye(req,resp);
	}
	
	private void dofengye(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Connection con=TasSQL.getConnection();	
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//定义每页的纪录行数（pageLine）、当前页（intPage，初始值为1）、总纪录数（totalRec）、
		//总页数（intPageCount）
		//String page = request.getParameter("page");
		String str_page = req.getParameter("page");
		if(str_page==null){
			str_page = "1";//初始化;
		}
		int intPage = Integer.parseInt(str_page);//字符转为int；
		if(intPage<1)   intPage=1;
		int thisPage = intPage;//记录为第几页.
		int totalRec= 0;
		int intPageCount=0;
		int pageLine= 5;//设定每页5行

		//取得总纪录数代码如下：

		String sql1="select count(*)as cnt from client";
	    ResultSet rs_totalRec;
		try {
			rs_totalRec = stmt.executeQuery(sql1);
			  if(rs_totalRec.next()){
			     	totalRec=rs_totalRec.getInt("cnt");
			    }
			    rs_totalRec.close();
				// 取得总页数代码如下：
				intPageCount=(totalRec+pageLine-1)/pageLine;
				//client是数据库中的表名
				ResultSet rs=stmt.executeQuery("select * from client");	

				if(intPageCount>0){ //如果总页数大于0，则执行下面语句
						for(int m=1;m<=(thisPage-1)*pageLine;m++)
						//页循环
							rs.next();//分页定位,确定开始显示的数据位置。
							for(int i=1;i<=pageLine;i++){
								if(rs.next()){
									String a=rs.getString(1);
									rs.getString(1);
									rs.getString(2);
									rs.getString(3);
									rs.getString(4);
									rs.getString(5);
									rs.getString(6);
								}
							}
				}else{
					System.out.println("数据库为空");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	}
}
