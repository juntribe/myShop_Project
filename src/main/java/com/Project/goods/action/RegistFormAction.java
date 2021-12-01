package com.Project.goods.action;

import com.Project.goods.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward("/goods/RegistForm.jsp",false);
		return forward;
	}
	
}