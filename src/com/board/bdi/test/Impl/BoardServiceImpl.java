package com.board.bdi.test.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.test.BoardDAO;
import com.board.bdi.test.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAOImpl bdao = new BoardDAOImpl();
	public Map<String,String> insertBoard(Map<String,String> board) {
		Map<String,String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		if(result == 1) {
			rMap.put("msg", "성공");
		}else {
			rMap.put("msg", "실패");
		}
		return rMap;
	}
	
	public static void main (String[] args) {
		
		BoardService bs = new BoardServiceImpl();
		Map<String,String> board = new HashMap<>();
		board.put("biTitle", "title test");
		board.put("biContent", "content test");
		board.put("uiNum", "7");
		
		Map<String,String> rMap = bs.insertBoard(board);
		System.out.println(rMap);
	}

	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> getBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		return null;
	}

}
