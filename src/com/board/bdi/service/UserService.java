package com.board.bdi.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public Map<String, String> doLogin(String id, String pwd);
	public Map<String, String> doSignup(String name, String id, String pwd);
	public List<Map<String,String>> doUserList(Map<String,String> user);
}
