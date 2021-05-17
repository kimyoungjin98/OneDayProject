package com.callor.diet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.config.DBInfo;
import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.model.MyFoodVO;

public class MyFoodServiceImplV1 implements MyFoodService {

	protected Connection dbConn;

	public MyFoodServiceImplV1() {

		dbConn = DBContract.getDBConnection();
	}

	public List<MyFoodCDTO> select(PreparedStatement pStr) throws SQLException {

		List<MyFoodCDTO> mfList = new ArrayList<MyFoodCDTO>();

		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {
			MyFoodCDTO dto = new MyFoodCDTO();

			dto.setMf_seq(rSet.getLong(DBInfo.섭취정보계산.mf_seq));
			dto.setMf_date(rSet.getString(DBInfo.섭취정보계산.mf_date));
			dto.setMf_fcode(rSet.getString(DBInfo.섭취정보계산.mf_fcode));
			dto.setMf_name(rSet.getString(DBInfo.섭취정보계산.mf_fname));
			dto.setMf_amt(rSet.getFloat(DBInfo.섭취정보계산.mf_amt));
			dto.setMf_one(rSet.getFloat(DBInfo.섭취정보계산.mf_one));
			dto.setMf_capa(rSet.getFloat(DBInfo.섭취정보계산.mf_capa));
			dto.setMf_cal(rSet.getFloat(DBInfo.섭취정보계산.mf_cal));
			dto.setMf_protein(rSet.getFloat(DBInfo.섭취정보계산.mf_protein));
			dto.setMf_fat(rSet.getFloat(DBInfo.섭취정보계산.mf_fat));
			dto.setMf_carvo(rSet.getFloat(DBInfo.섭취정보계산.mf_carbo));
			dto.setMf_sugar(rSet.getFloat(DBInfo.섭취정보계산.mf_sugar));

			mfList.add(dto);
		}

		return mfList;
	}

	@Override
	public List<MyFoodCDTO> selectAll() {
		// 전체 식품섭취 리스트

		String sql = " SELECT * FROM view_섭취량계산 ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodCDTO> myList = this.select(pStr);
			pStr.close();

			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MyFoodCDTO findById(Long seq) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_섭취량계산 ";
		sql += " WHERE 일련번호 = ? ";
		
		
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			List<MyFoodCDTO> myList = this.select(pStr);
			pStr.close();
			if(myList != null && myList.size() > 0) {
				return myList.get(0);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		String sql = " SELECT * FROM view_섭취량계산 ";
		sql += " WHERE 섭취일자 = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, mf_Date);
			List<MyFoodCDTO> myList = this.select(pStr);
			pStr.close();

			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
