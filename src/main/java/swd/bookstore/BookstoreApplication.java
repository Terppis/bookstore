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
			//your code... add some demodata to db
			Book book1= new Book(null, "Harry Potter ja salaisuuksien kammio", "J. K. Rowling", 1998, null, 0);
			Book book2 = new Book(null, "Tuntematon Kimi Räikkönen", "Kari Hotakainen", 2018, null, 0);
			System.out.println(book1);
			System.out.println(book2);
			bookRepository.save(book1);
			bookRepository.save(book2);
			
			Category category1= new Category(3, "Scifi");
			categoryRepository.save(category1);
			Category category2= new Category(4, "Horror");
			categoryRepository.save(category2);
			Category category3= new Category(5, "History");
			categoryRepository.save(category3);
			
			};		
		}
	
	
			
		}

	

