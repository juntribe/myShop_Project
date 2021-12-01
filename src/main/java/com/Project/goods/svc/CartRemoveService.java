package com.Project.goods.svc;

import com.Project.goods.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class CartRemoveService {
	
	public void cartRemove(HttpServletRequest request, String[]  nameArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < nameArray.length; i++) {
			
			for (int j = 0; j < cartList.size(); j++) {
				
				if(cartList.get(j).getName().equals(nameArray[i])){
						cartList.remove(cartList.get(j));
					
				}
				
			}
			
		}
		
	}
}