package com.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity hs) throws Exception {
		hs.csrf().disable().authorizeHttpRequests(auth -> auth.requestMatchers("/api/users/**").permitAll().anyRequest().authenticated()).httpBasic();
		return hs.build();
	}
}
