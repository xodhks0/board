package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	
	public Map<String,String> doLogin(String uiId, String uiPwd) {		
		Map<String,String> user = new HashMap<>();
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return udao.selectUser(user);
	}
	public Map<String,String> doSignup(String uiName, String uiId, String uiPwd) {
		Map<String,String> su = new HashMap<>();
		su.put("uiName", uiName);
		su.put("uiId", uiId);
		su.put("uiPwd", uiPwd);
		return udao.SignupUser(su);
	}
	public Map<String,String> doLogout(String uiName, String uiId, String uiPwd) {
		Map<String,String> lo = new HashMap<>();
		lo.put("uiName", uiName);
		lo.put("uiId", uiId);
		lo.put("uiPwd", uiPwd);
		return udao.SignupUser(lo);
	}
	
	public Map<String,String> doUpdate(String uiName, String uiId, String uiPwd) {
		Map<String,String> ud = new HashMap<>();
		ud.put("uiName", uiName);
		ud.put("uiId", uiId);
		ud.put("uiPwd", uiPwd);
		return udao.SignupUser(ud);
	}
	
	public List<Map<String,String>> doUserList(Map<String,String> user) {
		return udao.ListUser(user);
	}
}
