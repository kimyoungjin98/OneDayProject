package com.callor.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.DBContract;
import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodTotalDTO;
import com.callor.food.model.FoodVO;

public class FoodServiceImpl implements FoodService {

	protected Connection dbConn;

	public FoodServiceImpl() {

		dbConn = DBContract.getDBConnection();

	}

	protected List<FoodDTO> select(PreparedStatement pStr) {

		List<FoodDTO> foodList = new ArrayList<FoodDTO>();

		ResultSet rSet;
		try {
			rSet = pStr.executeQuery();
			
			while (rSet.next()) {

				FoodDTO foodDTO = new FoodDTO();
				foodDTO.setMf_seq(rSet.getInt("SEQ"));
				foodDTO.setMf_date(rSet.getString("날짜"));
				foodDTO.setMf_name(rSet.getString("식품명"));
				foodDTO.setMf_carbo(rSet.getInt("탄수화물"));
				foodDTO.setMf_energy(rSet.getInt("에너지"));
				foodDTO.setMf_fat(rSet.getInt("지방"));
				foodDTO.setMf_protein(rSet.getInt("단백질"));
				foodDTO.setMf_size(rSet.getInt("섭취량"));
				foodDTO.setMf_sugar(rSet.getInt("총 당류"));
				foodDTO.setMf_total(rSet.getInt("총 내용량"));

				foodList.add(foodDTO);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

		return foodList;
	}

	@Override
	public int insert(FoodVO foodVO, String fd_code) {

		String sql = " INSERT INTO tbl_myfoods(mf_seq,mf_date,mf_fcode,mf_size) ";
		sql += " VALUES (mf_seq.NEXTVAL, ?, ? ,?)";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.setString(1, foodVO.getF_date());
			pStr.setString(2, fd_code);
			pStr.setInt(3, foodVO.getF_size());
			
			int result = pStr.executeUpdate();
			pStr.close();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public List<FoodDTO> selectAll() {

		String sql = " SELECT * FROM view_섭취정보 ";
		
		PreparedStatement pStr = null;
	
			
			try {
				pStr = dbConn.prepareStatement(sql);
				List<FoodDTO> foodList = this.select(pStr);

				pStr.close();
				
				return foodList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return null;
	}
	



	@Override
	public List<FoodDTO> findByDate(String mf_date) {

		String sql = "SELECT * FROM view_섭취정보";
		sql += " WHERE 날짜 LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, mf_date);
			
			List<FoodDTO> foodList = this.select(pStr);
			
			pStr.close();
			
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public int delete(Integer mf_seq) {
		// 삭제
		
		String sql = " DELETE tbl_myfoods ";
		sql += " WHERE mf_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1, mf_seq);
			
			int result = pStr.executeUpdate();
			
			pStr.close();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
