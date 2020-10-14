package swd.bookstore.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd.bookstore.domain.Book;
import swd.bookstore.domain.BookRepository;
import swd.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	 
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Show booklist
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    
	// SHOW BOOKLIST
	@RequestMapping(value= "/booklist", method = RequestMethod.GET)
	public String getBooks (Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// REST GET BOOKS
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> booklistRest() {	
        return (List<Book>) repository.findAll();
    }    

	// REST GET BOOK BY ID
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    } 
    
    // REST SAVE NEW BOOK
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
    	return repository.save(book);
    }
    
	// ADDING BOOK
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "addbook";
		
	}
	//SAVING A BOOK
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String save(Book book){
	    repository.save(book);
	        
	    return "redirect:booklist";
	    
	}    
	//DELETING BOOK
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	//EDITING BOOK
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", repository.findById(bookId));
		
		return "editbook";	
	}
	
		
}
