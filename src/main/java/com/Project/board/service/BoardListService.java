package com.Project.board.service;

import com.Project.board.dao.BoardDAO;
import com.Project.board.vo.BoardBean;

import java.sql.Connection;
import java.util.ArrayList;

import static com.Project.board.JdbcUtil.close;
import static com.Project.board.JdbcUtil.getConnection;


public class BoardListService {

	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}

}
