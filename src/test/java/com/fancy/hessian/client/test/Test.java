package com.fancy.hessian.client.test;

import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.fancy.hessian.client.model.Book;
import com.fancy.hessian.client.service.BookService;

public class Test {
	public static void main(String[] args) {
		String url = "http://127.0.0.1:8080/fancycms/book";
		HessianProxyFactory factory = new HessianProxyFactory();
		try {
			BookService bookService = (BookService) factory.create(
					BookService.class, url);
			List<Book> list = bookService.getList();
			for (Book book : list) {
				System.out.println(book.getName() + ",定价为：" + book.getPrice()
						+ "元。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
