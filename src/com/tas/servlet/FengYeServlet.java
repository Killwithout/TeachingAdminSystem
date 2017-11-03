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
		//����ÿҳ�ļ�¼������pageLine������ǰҳ��intPage����ʼֵΪ1�����ܼ�¼����totalRec����
		//��ҳ����intPageCount��
		//String page = request.getParameter("page");
		String str_page = req.getParameter("page");
		if(str_page==null){
			str_page = "1";//��ʼ��;
		}
		int intPage = Integer.parseInt(str_page);//�ַ�תΪint��
		if(intPage<1)   intPage=1;
		int thisPage = intPage;//��¼Ϊ�ڼ�ҳ.
		int totalRec= 0;
		int intPageCount=0;
		int pageLine= 5;//�趨ÿҳ5��

		//ȡ���ܼ�¼���������£�

		String sql1="select count(*)as cnt from client";
	    ResultSet rs_totalRec;
		try {
			rs_totalRec = stmt.executeQuery(sql1);
			  if(rs_totalRec.next()){
			     	totalRec=rs_totalRec.getInt("cnt");
			    }
			    rs_totalRec.close();
				// ȡ����ҳ���������£�
				intPageCount=(totalRec+pageLine-1)/pageLine;
				//client�����ݿ��еı���
				ResultSet rs=stmt.executeQuery("select * from client");	

				if(intPageCount>0){ //�����ҳ������0����ִ���������
						for(int m=1;m<=(thisPage-1)*pageLine;m++)
						//ҳѭ��
							rs.next();//��ҳ��λ,ȷ����ʼ��ʾ������λ�á�
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
					System.out.println("���ݿ�Ϊ��");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	}
}
