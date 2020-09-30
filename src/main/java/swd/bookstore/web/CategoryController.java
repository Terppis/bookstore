package swd.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd.bookstore.domain.Category;
import swd.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	
	@RequestMapping(value= "/categorylist", method = RequestMethod.GET)
	public String getCategories (Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		
		return "newcategory";
		
	}
	
	@RequestMapping(value = "/savenew", method = RequestMethod.POST)
	 public String save(Category category){
	    repository.save(category);
	        
	    return "redirect:categorylist";
	    
	}
}
