package com.callor.diet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.model.MyFoodVO;

public class MyFoodServiceImplV1 implements MyFoodService{

	protected Connection dbConn;
	
	public MyFoodServiceImplV1() {
		
		dbConn = DBContract.getDBConnection();
	}
	
	@Override
	public List<MyFoodCDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodCDTO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> findByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> findByDate(String mf_Date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(MyFoodVO myfoodVO) {
		
		String sql = " INSERT INTO tbl_myfoods( ";
		sql += "mf_seq, mf_fcode, mf_date, mf_amt) "; 
		sql += " VALUES(seq_myfoods.NEXTVAL, ?, ?, ?) ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myfoodVO.getMf_fcode());
			pStr.setString(2, myfoodVO.getMf_date());
			pStr.setFloat(3, myfoodVO.getMf_amt());
			
			Integer result = pStr.executeUpdate();
			pStr.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Integer update(MyFoodVO myfoodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
