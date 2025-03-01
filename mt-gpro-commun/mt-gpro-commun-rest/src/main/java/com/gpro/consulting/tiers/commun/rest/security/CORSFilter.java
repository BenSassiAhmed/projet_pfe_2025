package com.gpro.consulting.tiers.commun.rest.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	response.addHeader("Access-Control-Allow-Origin", "*");
	response.addHeader("Access-Control-Allow-Headers","Content-Type");
	response.addHeader("Access-Control-Allow-Headers","Authorization");

    if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
        // CORS "pre-flight" request

    	
   
     	response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");

    	//response.addHeader("Access-Control-Allow-Headers","Content-Type");

        response.addHeader("Access-Control-Max-Age", "86400");
    }

    filterChain.doFilter(request, response);
  }

}

	