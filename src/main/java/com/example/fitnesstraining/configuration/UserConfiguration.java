package com.example.fitnesstraining.configuration;


import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.fitnesstraining.databaseauthprovider.CustomUserSetailService;
import com.example.fitnesstraining.jwtfilter.JwtFilter;
import com.example.fitnesstraining.userentity.UserEntity;

@Configuration
@EnableWebSecurity
public class UserConfiguration {
	
	@Autowired
	private JwtFilter jwtFilter;
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth ->
			auth.requestMatchers("/home").permitAll()
			.requestMatchers("/datas").authenticated()
			.anyRequest().permitAll()
			)
//		.formLogin(form -> form.permitAll().defaultSuccessUrl("/datas"))
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))
			.csrf(csrf -> csrf.disable())
			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
				
	}
@Bean
	public UserDetailsService userdetailsservice() {
//	public UserDetailsService userdetailsservice(PasswordEncoder passwordencoder) {
		
//			UserDetails user =User.withUsername("Ebi")
//			.password(passwordencoder.encode("123"))
//			.roles("user")
//			.build();
		
		return new CustomUserSetailService();
		
	}




@Bean
public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userdetailsservice());
    authProvider.setPasswordEncoder(passwordencoder());
    return authProvider;
}

	
@Bean
	public  PasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
	}
	

@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(List.of(authenticationProvider()));
	}

@Bean


public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedOrigin("http://localhost:3000"); // your React app
    configuration.addAllowedMethod("*"); // GET, POST, PUT, DELETE, etc.
    configuration.addAllowedHeader("*"); // Allow all headers
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}
	
}
