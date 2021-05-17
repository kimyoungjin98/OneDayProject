package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyFoodCDTO {

	private Long mf_seq;
	private String mf_date;
	private String mf_fcode;
	private String mf_name;
	private Float mf_amt;
	private Float mf_one;
	private Float mf_capa;
	private Float mf_cal;
	private Float mf_protein;
	private Float mf_fat;
	private Float mf_carvo;
	private Float mf_sugar;

}
