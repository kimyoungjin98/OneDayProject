package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodVO;
import com.callor.food.service.FoodService;
import com.callor.food.service.FoodServiceImpl;

@WebServlet("/diet/*")
public class FoodController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected FoodService foodService;
	
	public FoodController() {
		
		foodService = new FoodServiceImpl();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
				
			
		 if (subPath.equals("/insert")) {
			// 섭취정보 등록
			
			int size = 0;
			String f_fcode = req.getParameter("f_fcode");
			String f_size = req.getParameter("f_size");
			size = Integer.valueOf(f_size);
			
			
			
			Date date = new Date( System.currentTimeMillis() );
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			
			String sDate = sd.format(date);
			
			
			FoodVO foodVO = new FoodVO();
			
			foodVO.setF_date(sDate);
			foodVO.setF_fcode(f_fcode);
			foodVO.setF_size(size);
			
			int result = foodService.insert(foodVO);
			if(result > 0) {
				System.out.println("데이터 입력 성공");
			} else {
				System.out.println("데이터 입력 실패");
			}
			
			
		} else if (subPath.equals("/date")) {
			// 날짜순으로 조회
		
		} else if (subPath.equals("/fname")) {
			// 식품명으로 조회
			
		}
		
		
		
		
	}
	
	
	
	
	

	
	
}
