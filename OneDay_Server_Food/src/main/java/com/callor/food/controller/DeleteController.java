package com.callor.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.service.FoodService;
import com.callor.food.service.FoodServiceImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	protected FoodService foodService;

	public DeleteController() {

		foodService = new FoodServiceImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.getRequestDispatcher("/WEB-INF/views/delete.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("mf_seq");
		Integer mf_seq = Integer.valueOf(seq);

		int result = foodService.delete(mf_seq);
		
		if(result > 0) {
			System.out.println("데이터 삭제 완료");
		} else {
			System.out.println("데이터 삭제 실패");
		}
		
		
		
		resp.sendRedirect("/food");
	}

}
