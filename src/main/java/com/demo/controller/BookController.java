package com.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Book;
import com.demo.entity.MyBookList;
import com.demo.service.BookService;
import com.demo.service.MyBookService;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BookController {
	
	@Autowired
	private MyBookService myBooks;
	
	@Autowired 
	private BookService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_book")
	public ModelAndView getAllBook() {
		List<Book>list= service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
	
		return new ModelAndView("bookList","book",list);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b ) {
		service.save(b);
		return "redirect:/available_book";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=myBooks.getAllMyBooks();
		model.addAttribute("book",list);
		return "Mybook";
		
	}
	@RequestMapping("myList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList  mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		
		
		myBooks.saveMyBooks(mb);
		
		
		return "redirect:/my_books";
		}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookedit";
		
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_book";
	}
	
	
	

}
