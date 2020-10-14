package swd.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import swd.bookstore.domain.User;
import swd.bookstore.domain.UserRepository;
import swd.bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Autowired UserDetailServiceImpl userDetailsService;
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
        //.antMatchers("/delete/{id}").hasAuthority("ADMIN")
        .and()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
      .formLogin()
          .defaultSuccessUrl("/booklist")
          .permitAll()
          .and()
      .logout()
          .permitAll();
    }
    
    @Bean
	public CommandLineRunner userdemo(UserRepository userRepository) {
		return (args) -> {
			
			User user1= new User("teemu", "$2a$10$98WpMIwDT1Q1hJDuoC7EXu3lTyUeyKjXDuwJXaA3EoNo/Es4zlwLG", "testi.teemu@gmail.com", "ADMIN");
			User user2= new User("matti", "$2a$10$o7LOKuTBLObZuqX/a55ZLeWaDzvOTjRvI2tr8w7mc6ke89PvsBfme" ,"testi.matti@gmail.com", "USER");
			User user3= new User("liisa", "$2a$10$.PZPUSOruRZ2zxvcJ5yBZ.d4ABn/SqPfGFMpT2mnmdHkbhAF5D.02", "testi.liisa@gmail.com", "USER");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3); 
				
		};
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}