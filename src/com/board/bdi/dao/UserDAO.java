package com.board.bdi.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	public Map<String, String> selectUser(Map<String,String> user);
	public Map<String, String> SignupUser(Map<String,String> us);
	public List<Map<String, String>> ListUser(Map<String, String> lu);
}
