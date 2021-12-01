package com.Project.goods.action;

import com.Project.goods.svc.CartListService;
import com.Project.goods.vo.ActionForward;
import com.Project.goods.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class CartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CartListService cartListService = new CartListService();
		ArrayList<Cart> cartList = cartListService.getCartList(request);

		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("/goods/CartList.jsp", false);
		return forward;
	}

}
