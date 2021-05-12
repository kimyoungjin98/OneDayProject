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
	
	 private String mf_date;
     private String mf_fcode;
     private String mf_name;
     private String mf_amt;
     private String mf_one;
     private String mf_capa;
     private String mf_cal;
     private String mf_protein;
     private String mf_fat;
     private String mf_carvo;
     private String mf_sugar;

}
