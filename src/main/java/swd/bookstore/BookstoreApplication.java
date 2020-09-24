package swd.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd.bookstore.domain.Book;
import swd.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			//your code... add some demodata to db
			Book book1= new Book(null, "Harry Potter ja salaisuuksien kammio", "J. K. Rowling", 1998, null, 0);
			Book book2 = new Book(null, "Tuntematon Kimi Räikkönen", "Kari Hotakainen", 2018, null, 0);
			bookRepository.save(book1);
			bookRepository.save(book2);
			//tallennetaan tiedot tietokantaan
		};
	

	}
}
