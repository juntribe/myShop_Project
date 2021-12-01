package com.Project.goods.action;

import com.Project.goods.svc.CartQtyDownService;
import com.Project.goods.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		CartQtyDownService cartQtyDownService = new CartQtyDownService();
		cartQtyDownService.downCartQty(name,request);
		ActionForward forward = new ActionForward("CartList.gd",true);
		return forward;
	}

}
