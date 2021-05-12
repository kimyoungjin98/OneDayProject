package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodVO {
	
	private Long mf_seq;
	private String mf_date;
	private String mf_fcode;
	private Float mf_amt;

}
