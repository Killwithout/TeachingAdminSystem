package com.tas.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.tas.TasSQL.TasSQL;
import com.tas.vo.Video;


public class Sub {
		public Map sub(String ding){
			Map<String, Object> map=new HashMap<String, Object>();
			Statement stm=null;
			ResultSet rs=null;
			
			int curPage = 1;//当前的页码
			int maxPage;//总的页数
			int maxRows = 0;//总的行数
			int rowsPerPage = 2;//每页的行数
			Connection conn = TasSQL.getConnection();
			try {
				String sql = "select count(*) from video";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					maxRows = rs.getInt(1);
				}
				//TasSQL.closeConn();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			//计算应该 的页数
			if (maxRows % rowsPerPage == 0) {
				maxPage = maxRows / rowsPerPage;
			} else {
				maxPage = maxRows / rowsPerPage + 1;
			System.out.println("maxPage="+maxPage+"rowsPerPage="+rowsPerPage+"maxRows="+maxRows);
			}
			
			String temp = ding;
			
			if (temp == null) {
				temp = "1";
			}
			if (temp != "")
				curPage = Integer.parseInt(temp);
			Connection conn1 = TasSQL.getConnection();
			ArrayList<Object> list = new ArrayList<Object>();
			try {
				stm = conn1.createStatement();
				String sql = null;
				sql = "select top " + rowsPerPage
						+ " * from video where img_id not in(select top "
						+ rowsPerPage * (curPage - 1) + "img_id from video)";
				
				System.out.println(sql+"*********枫叶sql********");
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					Video video = new Video();
					video.setImg_id(rs.getString(2));
					video.setImg_path(rs.getString(3));
					list.add(video);
				}
				//TasSQL.closeConn();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			map.put("maxPage", maxPage);
			map.put("curPage", curPage);
			map.put("list", list);
			return map;
		}
}
