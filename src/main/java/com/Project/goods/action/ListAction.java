package com.Project.goods.action;

import com.Project.goods.svc.ListService;
import com.Project.goods.vo.ActionForward;
import com.Project.goods.vo.Goods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		ListService listService = new ListService();
		ArrayList<Goods> GoodsList = listService.getGoodsList();
		request.setAttribute("GoodsList", GoodsList);
		request.setAttribute("todayImageList", todayImageList);
		System.out.println("ListAction 실행");
		return new ActionForward("/goods/List.jsp", false);

	}
	
}
