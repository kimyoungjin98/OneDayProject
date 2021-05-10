package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodTotalDTO;

public interface FoodAllService {

	// 식품정보 조회
	public List<FoodTotalDTO> selectAll();
	
	public List<FoodTotalDTO> search(String name);
	
	// 식품코드로 조회
	public FoodTotalDTO findByCode(String fd_code);
	
	public void insert();
	
	public void delete();
	
	public void update();
	

}
