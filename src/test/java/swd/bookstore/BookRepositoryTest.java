package swd.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd.bookstore.domain.Book;
import swd.bookstore.domain.BookRepository;
import swd.bookstore.domain.Category;
import swd.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test
	public void createNewBook() {
		Book book = new Book (null, "Tuntematon Sotilas", "Väinö Linna", 1985, "123-12-512-133", 20.99, category3);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	Category category3 = new Category("History");
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	@Test
	public void createNewCategory() {
		categoryRepository.save(category3);
		assertThat(category3.getCategoryid()).isNotNull();
	}
	
	@Test
	public void findCategories() {
		categoryRepository.findAll();
	}
	
	@Test
	public void deleteCategory() {
		categoryRepository.deleteAll();
	}
	
	@Test
	public void findBooks() {
		repository.findAll();
	}
	
	@Test
	public void deleteBook() {
		repository.deleteAll();
	}
	
}
