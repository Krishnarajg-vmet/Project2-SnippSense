package com.kay.snippsense.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
		http 
			.authorizeHttpRequests(auth -> auth 
					.requestMatchers("/public/**", "/login", "/reset-password").permitAll() 
					.anyRequest().authenticated() 
					) 
			.formLogin(form -> form 
					.loginPage("/login") 
					.defaultSuccessUrl("/home", true) 
					.failureHandler((request, response, exception) -> { 
						exception.printStackTrace();
						response.sendRedirect("/login?error=true"); }) .permitAll()
					) 
			.logout(logout -> logout 
					.logoutUrl("/logout") 
					.logoutSuccessUrl("/login?logout=true") 
					.invalidateHttpSession(true) 
					.clearAuthentication(true) 
					.deleteCookies("JSESSIONID") 
					.permitAll() ) 
			.sessionManagement(session -> session 
					.sessionFixation().migrateSession() 
					.invalidSessionUrl("/sessionInvalid") 
					.maximumSessions(1) .maxSessionsPreventsLogin(false) 
					.expiredUrl("/sessionExpired") ); 
		return http.build(); 
		} 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
