package com.Project.goods.vo;

import java.net.URLEncoder;

public class Cart {
	
	private String image;
	private String name;
	private int price;
	private int qty;
	private String encodingName;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getEncodingName() {
		try {
			encodingName = URLEncoder.encode(name,"UTF-8");
		}catch (Exception e){
			e.printStackTrace();
		}
		return encodingName;
	}
}

