package com.callor.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO나 DTO는 DB와 관련한 데이터를 옮길때 사용하는 객체
 * 대부분의 역할이 유사하지만
 * 특별히 구분을 하는 이유는
 * 한개의 Table에 대하여
 * 다양한 View를 사용할때
 * 여러개의 VO나 DTO를 만들면서 
 * 이름을 짓는 것이 번거로워서 구분을 한다 
 * 
 * MyFoodVO : Insert, Update 용 
 * MyFoodDTO : SELECT 용
 * 
 * DTO(Data Transfer Object)
 * DB로부터 SELECT 데이터를 출력하는 곳
 * 옮길때 데이터를 사용할 객체
 */

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

	 private Integer mf_seq = 0;
	 private String mf_date; 
	 private String mf_name;
	 private Integer mf_size = 0;
     private Integer mf_total = 0; 
     private Integer mf_energy = 0;  
     private Integer mf_protein = 0;  
     private Integer mf_fat = 0; 
     private Integer mf_carbo = 0;
     private Integer mf_sugar = 0; 
	
}
