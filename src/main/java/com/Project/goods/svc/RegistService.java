package com.Project.goods.svc;

import com.Project.goods.dao.GoodsDAO;
import com.Project.goods.vo.Goods;

import java.sql.Connection;

import static com.Project.goods.db.JdbcUtil.*;

public class RegistService {

	public boolean registGoods(Goods goods) {
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		boolean isRegistSuccess = false;		
		int insertCount =goodsDAO.insertGoods(goods);

		
		if(insertCount>0){
			commit(con);
			isRegistSuccess=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}

}
