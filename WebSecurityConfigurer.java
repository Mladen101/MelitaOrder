package springboottest1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.springboot.entity.User;

@Configuration
	 public class WebSecurityConfigurer {

	     @Bean
	     public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
	         UserDetails user = ((WebSecurityConfigurer) ((WebSecurityConfigurer) User.withUsername("spring"))
	             .password(passwordEncoder.encode("secret")))
	             .roles("USER")
	             .build();
	         return new InMemoryUserDetailsManager(user);
	     }

	     private AbstractSecurityBuilder<DefaultSecurityFilterChain> roles(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		private Object password(String encode) {
			// TODO Auto-generated method stub
			return null;
		}

		@Bean
	     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	         http.authorizeRequests()
	             .antMatchers("/private/**")
	             .hasRole("USER")
	             .antMatchers("/public/**")
	             .permitAll()
	             .and()
	             .httpBasic();
	         return http.build();
	     }

	     @Bean
	     public BCryptPasswordEncoder passwordEncoder() {
	         return new BCryptPasswordEncoder();
	     }
	 }


