package com.Project.goods.svc;

import com.Project.goods.dao.GoodsDAO;
import com.Project.goods.vo.Goods;

import java.sql.Connection;
import java.util.ArrayList;

import static com.Project.goods.db.JdbcUtil.close;
import static com.Project.goods.db.JdbcUtil.getConnection;

public class ListService {

	public ArrayList<Goods> getGoodsList() {
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		ArrayList<Goods> goodsList = goodsDAO.selectGoodsList();
		close(con);
		return goodsList;
	}
	
}