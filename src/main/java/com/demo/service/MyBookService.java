package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MyBookDao;
import com.demo.entity.MyBookList;

@Service
public class MyBookService {
	@Autowired
	private MyBookDao mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
		
	}
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
	

}
