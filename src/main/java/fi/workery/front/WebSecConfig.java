package fi.workery.front;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled= true)
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	@Bean
    @Override
    public UserDetailsService userDetailsService() {
		//BYO userdetailsservice management
		
		return null;
 
    }

	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.defaultSuccessUrl("/tasks", true)
			.permitAll()
			.and()
		.logout()
			.logoutSuccessUrl("/")
			.permitAll();
		}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService()).passwordEncoder(passCoder());
    }
	
	@Bean
	public PasswordEncoder passCoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	            .ignoring()
	            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}


