/*====================================================
   #11. RegionDAO.java
   - 데이터베이스 액션 처리 클래스.
   - 지역 데이터 입력 / 출력 / 수정 / 삭제 액션.
   - Connection 객체에 대한 의존성 주입을 위한 준비
     → 인터페이스 형태의 속성 구성(DataSource)
     → setter 메소드 정의.
====================================================*/

package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class RegionDAO implements IRegionDAO
{
	// 인터페이스 자료형을 속성으로 구성	
	private DataSource dataSource;
	
	// setter 구성
<<<<<<< HEAD
	public void setDataSource(DataSource dataSource)
=======
	public void setDataSource(DataSource datasource)
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Region> list() throws SQLException
	{
		ArrayList<Region> result = new ArrayList<Region>();
		
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT REGIONID, REGIONNAME"
				+ ", DELCHECK"
				+ " FROM REGIONVIEW"
				+ " ORDER BY REGIONID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Region reg = new Region();
			
<<<<<<< HEAD
			reg.setRegionId(rs.getString("REGIONID"));
			reg.setRegionName(rs.getString("REGIONNAME"));
			reg.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(reg);
=======
			region.setRegionId(rs.getString("REGIONID"));
			region.setRegionName(rs.getString("REGIONNAME"));
			region.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(region);
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
		}
		rs.close();
		pstmt.close();
		conn.close();		
		
		
		
		return result;
	}

	@Override
	public int add(Region region) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();		
		String sql = "INSERT INTO REGION(REGIONID, REGIONNAME)"
				+ " VALUES(REGIONSEQ.NEXTVAL, ?);";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, region.getRegionName());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int remove(Region region) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "DELETE FROM REGION WHERE REGIONID=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(region.getRegionId()));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int modify(Region region) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "UPDATE REGION"
				+ " SET REGIONNAME=?"
				+ " WHERE REGIONID=?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, region.getRegionName());
		pstmt.setInt(2, Integer.parseInt(region.getRegionId()));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	
}
