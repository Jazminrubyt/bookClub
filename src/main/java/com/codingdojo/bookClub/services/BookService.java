package com.codingdojo.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.repositories.BookRepository;

@Service
public class BookService {

@Autowired
BookRepository bRepo;

// get all expenses
public List<Book> allBooks() {
	return bRepo.findAll();
}

// create new Expense 
public Book newBook(Book book) {
	return bRepo.save(book);
}

// Get one Expense 
public Book oneBook(Long id) {
	Optional<Book> book = bRepo.findById(id);
	if (book.isPresent()) {
		return book.get();
	} else {
		return null;
	}
}

public void deleteBook(Long id) {
	bRepo.deleteById(id);
}

public Book updateBook(Book book) {
	return bRepo.save(book);
}
}
