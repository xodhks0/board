package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public Map<String, String> selectUser(Map<String, String> user) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where ui_id= ? and ui_pwd= ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs = ps.executeQuery();
			if (rs.next()) {
				user.put("uiNum", rs.getString("ui_num"));
				user.put("uiName", rs.getString("ui_name"));
				user.put("credat", rs.getString("credat"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Map<String, String> SignupUser(Map<String,String> us) {
		try { 
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "insert into user_info(ui_num,ui_name,ui_id,ui_pwd,credat,cretim,moddat,modtim) ";
			sql += "values(seq_ui_num.nextval,?,?,?,to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24MISS'),to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24MISS'))";
			ps =con.prepareStatement(sql);
			ps.setString(1, us.get("uiName"));
			ps.setString(2, us.get("uiId"));
			ps.setString(3, us.get("uiPwd"));
		
		if (ps.executeUpdate() == 1) {
			Map<String, String> rMap= new HashMap<String, String>();
			rMap.put("msg", us.get("uiName")+"회원가입완료");
			rMap.put("url", "/views/user/login");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Map<String, String> UpdateUser(Map<String,String> udu) {
		try { 
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "update into user_info set ui_name = ?, ui_id = ?, ui_pwd= ? ";
			sql += " where ui_num = ui_num;";
			ps =con.prepareStatement(sql);
			ps.setString(1, udu.get("uiName"));
			ps.setString(2, udu.get("uiId"));
			ps.setString(3, udu.get("uiPwd"));
		
		if (ps.executeUpdate() == 1) {
			Map<String, String> rMap= new HashMap<String, String>();
			rMap.put("msg", udu.get("uiName")+"수정 완료");
			rMap.put("url", "/views/user/login");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	public List<Map<String, String>> ListUser(Map<String,String> user) {
		List<Map<String, String>> userlist = new ArrayList<>();
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "select * from user_info where 1=1 ";
			if(user.get("uiId")!=null) {
				sql += " and ui_Id=? ";
			}
			if(user.get("uiNum")!=null) {
				sql += " and ui_Num=? ";
			}
			if(user.get("uiName")!=null) {
				sql += " and ui_Name=? ";
			}
			sql += " order by ui_num desc ";
			ps =  con.prepareStatement(sql);
			if(user.get("uiId")!=null &&user.get("uiNum") == null && user.get("ui_name") == null){
				ps.setString(1, user.get("uiId"));
			} else if(user.get("uiId")==null &&user.get("uiNum") != null && user.get("ui_name") == null) {
				ps.setString(1, user.get("uiNum"));
			} else if(user.get("uiId")==null &&user.get("uiNum") == null && user.get("ui_name") != null) {
				ps.setString(1, user.get("uiName"));
			}
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String,String> map = new HashMap<>();
				map.put("ui_id", rs.getString("ui_id"));
				map.put("ui_num", rs.getString("ui_num"));
				map.put("ui_name", rs.getString("ui_name"));
				userlist.add(map);
			} 
			return userlist;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	public static void main(String[] args) {
		UserDAO udao = new UserDAOImpl();
		Map<String, String> user = new HashMap<>();
		user.put("uiId", "가나다라마라");
		user.put("uiPwd", "12345");
		user = udao.selectUser(user);
		System.out.println(user);
	}
}
