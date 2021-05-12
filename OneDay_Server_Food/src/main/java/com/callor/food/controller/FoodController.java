package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.callor.food.model.FoodTotalDTO;
import com.callor.food.model.FoodVO;
import com.callor.food.service.FoodAllService;
import com.callor.food.service.FoodAllServiceImpl;
import com.callor.food.service.FoodService;
import com.callor.food.service.FoodServiceImpl;

@WebServlet("/diet/*")
public class FoodController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected FoodService foodService;
	protected FoodAllService foodAllService;

	public FoodController() {

		foodService = new FoodServiceImpl();
		foodAllService = new FoodAllServiceImpl();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

			
		if (subPath.equals("/date")) {
			// 날짜순으로 조회
			
			String mf_date = req.getParameter("mf_date");
			
			List<FoodDTO> foodList = foodService.findByDate(mf_date);
			
			for(FoodDTO ftDTO : foodList) {
				
			}
			
			req.setAttribute("FoodList", foodList);
			
			req.getRequestDispatcher("/WEB-INF/views/date.jsp").forward(req, resp);

		}  else if (subPath.equals("/foodList")) {

			List<FoodTotalDTO> fList = foodAllService.selectAll();

			FoodTotalDTO ftDTO = new FoodTotalDTO();

			req.setAttribute("fLIST", fList);
			req.setAttribute("fFOOD", ftDTO);

			req.getRequestDispatcher("/WEB-INF/views/foodList.jsp").forward(req, resp);

		}  else if (subPath.equals("/foodList/code")) {

			String fd_code = req.getParameter("fd_code");
			FoodTotalDTO foodTotalDTO = foodAllService.findByCode(fd_code);

			req.setAttribute("FOOD", foodTotalDTO);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/foodCode.jsp");
			disp.forward(req, resp);

		}

	}
	
	

}
