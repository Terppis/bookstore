package swd.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd.bookstore.web.BookController;
import swd.bookstore.web.CategoryController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {


	@Autowired
	private BookController bookController;
	
	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
	}
	
	@Autowired
	private CategoryController categoryController;
	
	@Test
	public void contextLoads2() {
		assertThat(categoryController).isNotNull();
	}

}

