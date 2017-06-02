package com.fancy.hessian.client.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fancy.hessian.client.model.Book;
import com.fancy.hessian.client.service.BookService;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-context.xml");
		BookService bookService = (BookService) cxt.getBean("getBookService");
		List<Book> list = bookService.getList();
		for (Book book : list) {
			System.out.println(book.getName() + ",定价为：" + book.getPrice()
					+ "元。");
		}
	}
}
