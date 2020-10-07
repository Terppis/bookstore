package swd.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd.bookstore.domain.Category;
import swd.bookstore.domain.CategoryRepository;

@Controller
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	
	@RequestMapping(value= "/categorylist", method = RequestMethod.GET)
	public String getCategories (Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}	
	
	// RESTful service to get all categories
    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategoriesRest() {	
        return (List<Category>) repository.findAll();
    }    

	// RESTful service to get category by id
    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {	
    	return repository.findById(categoryId);
    } 
    
    // RESTful service to save new category
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {	
    	return repository.save(category);
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
