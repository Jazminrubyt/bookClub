package com.codingdojo.bookClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookClub.models.LoginUser;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.services.BookService;
import com.codingdojo.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	UserService users;
	@Autowired
	BookService books;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newLogin", new LoginUser());
		model.addAttribute("newUser", new User());
		return "index.jsp";
	}
	
	// make sure to protect your routes!!!!
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		users.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
		
			return "index.jsp";
		}
		session.setAttribute("userId",newUser.getId());
		return "redirect:/homepage";
	}
	// make sure to protect your routes!!!!
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = users.login(newLogin,result);
		if(result.hasErrors()) {
		
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/homepage";
	}
	// make sure to protect your routes!!!!
	@GetMapping("/homepage")
	public String homepage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
		model.addAttribute("books",books.allBooks());
		model.addAttribute("user",users.getUserById(userId));
		return "homepage.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

