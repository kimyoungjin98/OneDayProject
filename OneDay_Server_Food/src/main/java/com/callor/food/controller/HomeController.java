package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodDTO;
import com.callor.food.service.FoodService;
import com.callor.food.service.FoodServiceImpl;

@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected FoodService foodService;

	public HomeController() {

		foodService = new FoodServiceImpl();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		resp.setContentType("text/html;charset=UTF-8");

		FoodDTO foodDTO = new FoodDTO();
		List<FoodDTO> foodList = foodService.selectAll();

		System.out.println(foodList.toString());

		ServletContext app = this.getServletContext();

		app.setAttribute("FoodList", foodList);
		app.setAttribute("List", foodDTO);

		RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/list.jsp");
		disp.forward(req, resp);

	}

}
