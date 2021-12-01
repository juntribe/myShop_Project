package com.Project.goods.svc;

import com.Project.goods.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class CartListService {
	
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		return cartList;
	}
	
}
