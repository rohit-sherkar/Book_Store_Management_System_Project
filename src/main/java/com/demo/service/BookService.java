package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDao;
import com.demo.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bD;

	public void save(Book b) {
		bD.save(b);

	}

	public List<Book> getAllBook() {
		return bD.findAll();
	}

	public Book getBookById(int id) {
		return bD.findById(id).get();
	}

	public void deleteById(int id) {
		bD.deleteById(id);

	}

}
