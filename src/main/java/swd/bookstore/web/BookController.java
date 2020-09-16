package swd.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd.bookstore.domain.Book;

@Controller
public class BookController {
	
	
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String getBooks (Model model) {
		
		List <Book> books = new ArrayList<Book>();
		books.add(new Book("Harry Potter ja salaisuuksien kammio ", "J.K Rowling ", 1998, "192391239 ", 15.00));
		System.out.println(books);
		model.addAttribute("books", books);
		return "bookstore";
	}
}
