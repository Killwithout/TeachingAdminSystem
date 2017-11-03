package com.tas.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tas.TasSQL.TasSQL;
import com.tas.dao.GuanliDao;

public class GuanliDaoimp implements GuanliDao {
	Connection conn= TasSQL.getConnection();
	PreparedStatement pstm=null;
	ResultSet rs = null;
	boolean flag=false;
	public boolean g_login(String t_id, String t_pass) {
		String sql="select t_id from teacher where t_id=? and t_pass=?";
						
			
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, t_id);
				pstm.setString(2, t_pass);
				rs =pstm.executeQuery();
				
				while(rs.next()){
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return flag;
		
	}

}
