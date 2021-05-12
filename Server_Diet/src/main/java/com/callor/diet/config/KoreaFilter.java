package com.callor.diet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class KoreaFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, 
					ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		// TODO 한글 Encoding 설정
		/*
		 * 프로젝트의 모든 Controller로 요청되는
		 * 데이터들의 문자 Encoding을 설정하고
		 * 
		 * Controller에서 Web 으로 응답하는
		 * 데이터들의 ContentType을 설정하기
		 */
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		chain.doFilter(req, res);
		
	}

	
	
}
