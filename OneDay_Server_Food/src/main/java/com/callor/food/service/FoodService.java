package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodTotalDTO;
import com.callor.food.model.FoodVO;

public interface FoodService {

	// 데이터 입력
	public int insert(FoodVO foodVO);
	
	// 전체 데이터 조회
	public List<FoodDTO> selectAll();
	
	// 식품정보 조회
	public List<FoodTotalDTO> selectTotal();
	
	// 날짜별로 데이터 조회
	public List<FoodDTO> findByDate();
	
	// 데이터 업데이트
	public void update();
	
	// 데이터 삭제
	public void delete();


	
}
