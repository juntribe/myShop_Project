package com.Project.goods.action;

import com.Project.goods.svc.CartRemoveService;
import com.Project.goods.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] nameArray = request.getParameterValues("remove");
		CartRemoveService cartRemoveService = new CartRemoveService();
		cartRemoveService.cartRemove(request,nameArray);
		ActionForward forward = new ActionForward("CartList.gd",true);
		return forward;
	}
	
}