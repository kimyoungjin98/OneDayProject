package com.callor.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.DBContract;
import com.callor.food.model.FoodTotalDTO;

public class FoodAllServiceImpl implements FoodAllService {
	
	protected Connection dbConn;
	
	public FoodAllServiceImpl() {
		
		dbConn = DBContract.getDBConnection();
		
	}

	protected List<FoodTotalDTO> select(PreparedStatement pStr) {

		List<FoodTotalDTO> foodList = new ArrayList<FoodTotalDTO>();

		ResultSet rSet;
		try {
			rSet = pStr.executeQuery();

			while (rSet.next()) {

				FoodTotalDTO foodTotalDTO = new FoodTotalDTO();
				foodTotalDTO.setCp_name(rSet.getString("제조사명"));
				foodTotalDTO.setCp_code(rSet.getString("제조사코드"));
				foodTotalDTO.setFd_carbo(rSet.getInt("탄수화물(g)"));
				foodTotalDTO.setFd_code(rSet.getString("식품코드"));
				foodTotalDTO.setFd_energy(rSet.getInt("에너지(kcal)"));
				foodTotalDTO.setFd_fat(rSet.getInt("지방(g)"));
				foodTotalDTO.setFd_name(rSet.getString("식품명"));
				foodTotalDTO.setFd_protein(rSet.getInt("단백질(g)"));
				foodTotalDTO.setFd_serv(rSet.getInt("1회제공량"));
				foodTotalDTO.setFd_sugar(rSet.getInt("총 당류(g)"));
				foodTotalDTO.setFd_total(rSet.getInt("총내용량"));
				foodTotalDTO.setFd_year(rSet.getString("출시연도"));
				foodTotalDTO.setIt_code(rSet.getString("분류코드"));
				foodTotalDTO.setIt_name(rSet.getString("분류명"));

				foodList.add(foodTotalDTO);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return foodList;
	}

	@Override
	public List<FoodTotalDTO> selectAll() {
		
		String sql = " SELECT * FROM view_식품정보 ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodTotalDTO> foodList = this.select(pStr);
			
			pStr.close();
			
			return foodList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return null;
	}
	
	@Override
	public List<FoodTotalDTO> search(String name) {
		
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";
						
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			List<FoodTotalDTO> foodList = this.select(pStr);
			
			pStr.close();
			
			return foodList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public FoodTotalDTO findByCode(String fd_code) {
		
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품코드 = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_code);
			List<FoodTotalDTO> foodList = this.select(pStr);
			
			FoodTotalDTO foodTotalDTO = null;
			
			if(foodList != null && foodList.size() > 0) {
				foodTotalDTO = foodList.get(0);
			}
			
			pStr.close();
			
			return foodTotalDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}


	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	
	

}

