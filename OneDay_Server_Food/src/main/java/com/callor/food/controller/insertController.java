package com.callor.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodVO;
import com.callor.food.service.FoodService;
import com.callor.food.service.FoodServiceImpl;

@WebServlet("/insert")
public class insertController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected FoodService foodService;

	public insertController() {

		foodService = new FoodServiceImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fd_code = req.getParameter("f_fcode");
		String f_date = req.getParameter("f_date");
		String f_size = req.getParameter("f_size");
		Integer size = Integer.valueOf(f_size);

		FoodVO foodVO = new FoodVO();

		foodVO.setF_date(f_date);
		foodVO.setF_fcode(fd_code);
		foodVO.setF_size(size);

		int result = foodService.insert(foodVO, fd_code);

		if (result > 0) {
			System.out.println("데이터 입력 성공");
		} else {
			System.out.println("데이터 입력 실패");
		}
		
		resp.sendRedirect("/food/foodList");

	}

}
