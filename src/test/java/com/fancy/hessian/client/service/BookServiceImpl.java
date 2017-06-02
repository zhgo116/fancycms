package com.fancy.hessian.client.service;

import java.util.ArrayList;
import java.util.List;

import com.caucho.hessian.server.HessianServlet;
import com.fancy.hessian.client.model.Book;

public class BookServiceImpl extends HessianServlet implements BookService {

	private static final long serialVersionUID = 3144369175294347301L;

	@Override
	public List<Book> getList() {
		List<Book> list=new ArrayList<Book>(); 
        Book b1=new Book(); 
        b1.setName("《信息简史》"); 
        b1.setPrice(56); 
        Book b2=new Book(); 
        b2.setName("《黑客与画家》"); 
        b2.setPrice(48); 
        list.add(b1); 
        list.add(b2); 
        return list; 
	}

}
