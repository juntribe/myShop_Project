package com.Project.goods.action;

import com.Project.goods.svc.CartQtyUpService;
import com.Project.goods.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		CartQtyUpService cartQtyUpService = new CartQtyUpService();
		cartQtyUpService.upCartQty(name,request);
		ActionForward forward = new ActionForward("CartList.gd", true);
		return forward;
	}

}
