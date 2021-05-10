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

		if (subPath.equals("/insert")) {
			// 섭취정보 등록

			Integer size = 0;

			String fd_code = req.getParameter("f_fcode");
			String f_date = req.getParameter("f_date");
			String f_size = req.getParameter("f_size");
			size = Integer.valueOf(f_size);

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

			req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
			
		} else if (subPath.equals("/date")) {
			// 날짜순으로 조회

		} else if (subPath.equals("/fname")) {
			// 식품명으로 조회

		} else if (subPath.equals("/foodList")) {

			List<FoodTotalDTO> fList = foodAllService.selectAll();

			FoodTotalDTO ftDTO = new FoodTotalDTO();

			req.setAttribute("fLIST", fList);
			req.setAttribute("fFOOD", ftDTO);

			req.getRequestDispatcher("/WEB-INF/views/foodList.jsp").forward(req, resp);

		} else if (subPath.equals("/foodList/select")) {

			String fd_name = req.getParameter("fd_name");
			List<FoodTotalDTO> foodList = foodAllService.search(fd_name);

			for (FoodTotalDTO foodTotalDTO : foodList) {
				System.out.println(foodList.toString());
			}

			req.setAttribute("FOODLIST", foodList);

			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/selectFood.jsp");
			disp.forward(req, resp);

		} else if (subPath.equals("/foodList/code")) {

			String fd_code = req.getParameter("fd_code");
			FoodTotalDTO foodTotalDTO = foodAllService.findByCode(fd_code);

			req.setAttribute("FOOD", foodTotalDTO);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/foodCode.jsp");
			disp.forward(req, resp);

		}

	}

}
