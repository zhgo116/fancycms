package com.fancy.hessian.client.model;

import java.io.Serializable;

public class Book implements Serializable{//hessian必须实现序列化接口
	private static final long serialVersionUID = -933666813173415503L;
	private String name;
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
