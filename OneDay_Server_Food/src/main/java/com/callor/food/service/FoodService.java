package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodTotalDTO;
import com.callor.food.model.FoodVO;

public interface FoodService {

	// 데이터 입력
	public int insert(FoodVO foodVO, String fd_code);
	
	// 전체 데이터 조회
	public List<FoodDTO> selectAll();
	
	
	// 날짜별로 데이터 조회
	public List<FoodDTO> findByDate(String mf_date);
	
	// 데이터 업데이트
	public void update();
	
	// 데이터 삭제
	public int delete(Integer mf_seq);


	
}
