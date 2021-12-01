package com.Project.goods.action;

import com.Project.goods.svc.ViewService;
import com.Project.goods.vo.ActionForward;
import com.Project.goods.vo.Goods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ViewService viewService = new ViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		Goods goods = viewService.getGoodsView(id);
		request.setAttribute("goods", goods);
		Cookie todayImageCookie = new Cookie("today"+id, goods.getImage());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		return new ActionForward("/goods/View.jsp", false);
	}
	
}