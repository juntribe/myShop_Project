package com.Project.goods.svc;

import com.Project.goods.dao.GoodsDAO;
import com.Project.goods.vo.Cart;
import com.Project.goods.vo.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

import static com.Project.board.JdbcUtil.close;
import static com.Project.board.JdbcUtil.getConnection;


public class CartAddService {

	public Goods getCart(int id) {
		Connection con = getConnection();

		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		Goods goods = goodsDAO.selectGoods(id);
		close(con);
		return goods;
	}

	public void addCart(HttpServletRequest request, Goods cartGoods) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null){
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;

		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartGoods.getName().equals(cartList.get(i).getName())){
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartGoods.getImage());
			cart.setName(cartGoods.getName());
			cart.setPrice(cartGoods.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}