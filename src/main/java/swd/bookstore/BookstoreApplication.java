package swd.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd.bookstore.domain.Book;
import swd.bookstore.domain.BookRepository;
import swd.bookstore.domain.Category;
import swd.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			Category category1= new Category( "Scifi");
			categoryRepository.save(category1);
			Category category2= new Category( "Horror");
			categoryRepository.save(category2);
			Category category3= new Category( "History");
			categoryRepository.save(category3);
			Category category4= new Category( "Fantasy");
			categoryRepository.save(category4);
			Category category5= new Category( "Fiction");
			categoryRepository.save(category5);
			
			
			bookRepository.save(new Book (null, "Harry Potter ja salaisuuksien kammio", "J. K. Rowling", 1998, null, 0, category1));
			bookRepository.save(new Book (null, "Tuntematon Kimi Räikkönen", "Kari Hotakainen", 2018, null, 0, category3 ));
				
		};
	
	
			
	}
}
	

