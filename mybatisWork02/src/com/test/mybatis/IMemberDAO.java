/* ==================================
	IMemberDAO.java
	- 인터페이스
	- 원래는 DAO 메소드 선언할 때는
	  오버라이딩 할 때 예외 추가안돼서
	  붙혀서 만들었는데
	- 마이바티스를 사용하면서 
	  필요없음.
================================== */
package com.test.mybatis;

import java.util.ArrayList;

public interface IMemberDAO
{
	// 데이터 입력 메소드
	public int add(MemberDTO m);
	// 인원수 구하는 메소드
	public int count();
	// 전체 회원 리스트 조회 메소드
	public ArrayList<MemberDTO> list();
	
	// 삭제
	public int del(String mid);
	
	
	
}
