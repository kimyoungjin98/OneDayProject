package com.callor.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO 클래스는 Insert, Update를 수행할때
 * 사용자(Web)가 입력한(전달받은) 값을 담을 객체
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
	
	private String f_date;
	private String f_fcode;
	private Integer f_size = 0;

}
