/* =================================
	MemberListController.java
	- 사용자 정의 컨트롤러 클래스
	- 리스트 출력 액션
	- DAO 객체에 대한 의존성 주입
	  준비 → setter 메소드 추가
================================= */
package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 『Controller』 인터페이스를 구현하는 방법을 통해
//    사용자 정의 컨트롤러 클래스를 구성한다.

public class MemberListController implements Controller
{
	// 인터페이스 자료형을 취하는 속성 구성
	private IMemberDAO dao;
	
	// setter 메소드 구성, 생성자
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 컨트롤러가 수행하는 액션 코드
		
		ModelAndView mav = new ModelAndView();
		
		int count = 0;
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		//String view = 모델객체 메소드();
		try
		{
			count = dao.count();
			memberList = dao.list();
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		mav.setViewName("/WEB-INF/view/MemberList.jsp");
		//mav.setViewName(view);
		mav.addObject("count", count);
		mav.addObject("memberList", memberList);
		
		return mav;
	}

	
	
}
