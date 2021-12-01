package com.Project.goods.action;

import com.Project.goods.svc.CartAddService;
import com.Project.goods.vo.ActionForward;
import com.Project.goods.vo.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CartAddService cartAddService = new CartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Goods cart = cartAddService.getCart(id);
		cartAddService.addCart(request,cart);
		ActionForward forward = new ActionForward("CartList.gd", true);
		return forward;
	}

}
