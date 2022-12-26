package com.main;

 
    import org.springframework.context.annotation.*;  
    import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;  
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;    
	import org.springframework.security.config.annotation.web.configuration.*;    
    import org.springframework.security.core.userdetails.*;  
    import org.springframework.security.core.userdetails.User.UserBuilder;    
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;  
    import org.springframework.security.web.util.matcher.AntPathRequestMatcher;    
    @EnableWebSecurity    
    @ComponentScan("com.java")    
    @EnableGlobalMethodSecurity(prePostEnabled=true)  
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {    
    @Bean    
    public UserDetailsService userDetailsService() {  
        // ensure the passwords are encoded properly  
    UserBuilder users = User.withDefaultPasswordEncoder();  
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
	manager.createUser(users.username("Mladen").password("user123").roles("USER").build());  
	manager.createUser(users.username("admin").password("admin123").roles("ADMIN").build());  
    return manager;  
	    }   
	@Override    
	protected void configure(HttpSecurity http) throws Exception {    
	      http.authorizeRequests().  
	      antMatchers("/index","/").permitAll()  
	      .antMatchers("/admin","/user").authenticated()  
	      .and()  
	      .formLogin()  
	      .and()  
	      .logout()  
	      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));  
	}    
	}    
