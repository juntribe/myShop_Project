package com.Project.goods.vo;

public class Goods {

	private int id;
	private String name;
	private int price;
	private String image;
	private int size;
	private String color ;
	private String content;
	private int readcount;

	public Goods(int id, String name, int price, String image, int size, String color, String content, int readcount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.size = size;
		this.color = color;
		this.content = content;
		this.readcount = readcount;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

}
