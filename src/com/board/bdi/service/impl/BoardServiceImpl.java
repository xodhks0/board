package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();

	public static void main(String[] args) {
		BoardService bdao = new BoardServiceImpl();
		List<Map<String,String>> list = bdao.getBoardList(null);
		System.out.println(list);
	}
	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {
		return bdao.selectBoardList(board);
	}

	@Override
	public Map<String, String> getBoard(Map<String, String> board) {
		return bdao.selectBoard(board);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String,String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		if(result==1) {
			rMap.put("msg","게시물 생성이 완료되었습니다.");
			rMap.put("url","/board/list");
		}else {
			rMap.put("msg","게시물 생성이 실패하였습니다.");
			rMap.put("url","/views/board/insert");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		int result = bdao.updateBoard(board);
		Map<String,String> rMap = new HashMap<>();
		if(result==1) {
			rMap.put("msg","게시물이 수정 되었습니다.");
			rMap.put("url","/board/view?biNum=" + board.get("biNum"));
		}else {
			rMap.put("msg","게시물 삭제가 실패하였습니다.");
			rMap.put("url","/board/view?biNum=" + board.get("biNum"));
		}
		return rMap;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		int result = bdao.deleteBoard(board);
		Map<String,String> rMap = new HashMap<>();
		if(result==1) {
			rMap.put("msg","게시물이 삭제되었습니다.");
			rMap.put("url","/board/list");
		}else {
			rMap.put("msg","게시물 삭제가 실패하였습니다.");
			rMap.put("url","/board/view?biNum=" + board.get("biNum"));
		}
		return rMap;
	}

}
