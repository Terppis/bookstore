package swd.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd.bookstore.domain.User;
import swd.bookstore.domain.UserRepository;

	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class UserRepositoryTest {
		
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createNewUser() {
	User user1 = new User ("teemu", "$2a$10$3Ub.uR3Ch.HCJCturDXOpOouV6tgVODSCjHwfWFA1BeQy2Dnx.M1m", "testi.teemu@gmail.com", "ADMIN" );
	userRepository.save(user1);	
	}
	
	@Test
	public void findByUsernameShouldReturnUser() {
		userRepository.findByUsername("teemu");
	}
	
	@Test
	public void deleteUsers() {
		userRepository.deleteAll();
	}
	

	
	
	
}