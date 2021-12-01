package com.Project.goods.svc;

import com.Project.goods.dao.GoodsDAO;
import com.Project.goods.vo.Goods;

import java.sql.Connection;

import static com.Project.goods.db.JdbcUtil.*;

public class ViewService {

	public Goods getGoodsView(int id) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		int updateCount = goodsDAO.updateReadCount(id);

		if(updateCount>0){
			commit(con);
		}else{
			rollback(con);
		}
		
		Goods goods = goodsDAO.selectGoods(id);
		close(con);
		return goods;
	}

}
