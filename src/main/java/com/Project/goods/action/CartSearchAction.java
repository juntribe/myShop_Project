package com.Project.goods.action;

import com.Project.goods.svc.CartSearchService;
import com.Project.goods.vo.ActionForward;
import com.Project.goods.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class CartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CartSearchService cartSearchService = new CartSearchService();
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		ArrayList<Cart> cartList =
		cartSearchService.getCartSearchList(startMoney,endMoney,request);
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		return new ActionForward("/goods/CartList.jsp", false);
	}
	
}
