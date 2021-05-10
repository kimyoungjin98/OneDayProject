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
public class FoodTotalDTO {

	private String fd_code; 
	private String fd_name; 
	private String fd_year;  
	private String cp_code; 
	private String cp_name;  
	private String it_code;  
	private String it_name;  
	private Integer fd_serv = 0; 
	private Integer fd_total = 0;  
	private Integer fd_energy = 0; 
	private Integer fd_protein = 0;   
	private Integer fd_fat = 0;  
	private Integer fd_carbo = 0;  
	private Integer fd_sugar = 0; 
	
}
