package com.codingdojo.bookClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.services.BookService;
import com.codingdojo.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	BookService books;
	@Autowired
	UserService users;
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/book/form")
	public String bookForm(@ModelAttribute("book")Book book) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		return "bookForm.jsp";
	}
	
	@PostMapping("create/book")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "bookForm.jsp";
		}
		else {
			User user = users.getUserById(userId);
			book.setUser(user);
			books.newBook(book);
		}
		return "redirect:/homepage";
	}
	@GetMapping("/view/book/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("books",books.oneBook(id));
		return "viewBook.jsp";
	}
	@DeleteMapping("/delete/book/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		books.deleteBook(id);
		return "redirect:/homepage";
	}
	@GetMapping("/edit/book/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("books",books.oneBook(id));
		return"editBook.jsp";

	}

	@PutMapping("/update/book/{id}")
	public String updateArtist(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,@PathVariable("id") Long id) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("books", books.oneBook(id));
			return "editBook.jsp";
		}else {
			User user = users.getUserById(userId);
			book.setUser(user);
			return "redirect:/homepage";
		}
	}
}
