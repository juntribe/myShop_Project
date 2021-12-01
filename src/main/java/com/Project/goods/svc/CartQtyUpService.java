package com.Project.goods.svc;

import com.Project.goods.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CartQtyUpService {

	public void upCartQty(String name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			
			if(cartList.get(i).getName().equals(name)){
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
			}
			
		}
		
	}
	
}
