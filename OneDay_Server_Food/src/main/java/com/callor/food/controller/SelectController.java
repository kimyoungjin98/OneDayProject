package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodTotalDTO;
import com.callor.food.service.FoodAllService;
import com.callor.food.service.FoodAllServiceImpl;

@WebServlet("/select")
public class SelectController extends HttpServlet{
	
	FoodAllService foodAllService;
	
	public SelectController() {
		
		foodAllService = new FoodAllServiceImpl();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.setCharacterEncoding("UTF-8");
		
		String fd_name = req.getParameter("fd_name");
		List<FoodTotalDTO> foodList = foodAllService.search(fd_name);
		
//		resp.setContentType("text/html;charset=UTF-8");

		for (FoodTotalDTO foodTotalDTO : foodList) {
			System.out.println(foodList.toString());
		}

		req.setAttribute("FOODLIST", foodList);
		
		

		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/selectFood.jsp");
		disp.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
			

		}
		
	}

	
	
