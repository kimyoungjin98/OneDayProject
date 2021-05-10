package com.callor.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
