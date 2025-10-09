package com.example.fitnesstraining.jwtfilter;

import java.io.IOException;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.fitnesstraining.databaseauthprovider.CustomUserSetailService;
import com.example.fitnesstraining.jwtutill.JwtUtill;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtill jwtUtill;
	
	@Autowired 
	private CustomUserSetailService customUserSetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
				String authHeader = request.getHeader("Authorization");
				
				if (authHeader == null || !authHeader.startsWith("Bearer ")) {
					filterChain.doFilter(request, response);
					return;
				}
				
				String token =authHeader.substring(7);
				
				try {
					String UserEmail = jwtUtill.ExstractUserEmail(token);
					if (UserEmail != null && SecurityContextHolder.getContext().getAuthentication() ==null) {
						UserDetails userDetails = customUserSetailService.loadUserByUsername(UserEmail);
						
						if (jwtUtill.ValidateToken(token, userDetails)) {
								UsernamePasswordAuthenticationToken authenticationToken =new 
										UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
										authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
										SecurityContextHolder.getContext().setAuthentication(authenticationToken);
						}
					}
				} catch (Exception e) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					return;
				}
		
				filterChain.doFilter(request, response);
	}
	

		
	

}
