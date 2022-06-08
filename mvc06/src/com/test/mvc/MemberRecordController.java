/* =================================
	MemberRecordController.java
	- 사용자 정의 컨트롤러 클래스
================================= */
package com.test.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRecordController 
{
	// ※ 액션 처리를 위한 메소드는 사용자가 지정.
	/*
	@RequestMapping
	public 변환자료형 메소드이름(매개변수)
	{
		// ※ 업무 로직 처리 (비즈니스 로직 처리 → 모델 활용)
		//    ...
		 
		return "뷰 이름.jsp";
	}
	*/
	
	// 데이터베이스의 리스트를 읽어오는 과정
	@RequestMapping("/memberlist.action")
	public String memberList(Model model)
	{
		String result = "";
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		//DI 과정 생략
		MemberDAO dao = new MemberDAO();
		
		try
		{
			dao.connection();
			list = dao.lists();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{
				dao.close();
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		model.addAttribute("list", list);
		
		result = "/WEB-INF/view/MemberList.jsp";
		
		return result;
		
	}
	
	// 데이터 입력(회원 등록)폼 요청 관련 액션 메소드 정의
	@RequestMapping("/memberinsertform.action")
	public String memberInsertForm()
	{
		String result = "/WEB-INF/view/MemberInsertForm.jsp";
		
		return result;
		
	}
	
	// 데이터 입력(회원 등록) 액션 메소드 정의
	@RequestMapping("/memberinsert.action")
	public String memberInsert(MemberDTO dto)
	{
		
		String result ="";
		MemberDAO dao = new MemberDAO();
		
		
		try
		{
			dao.connection();
			
			dao.insertQuery(dto);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{
				dao.close();
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
			
		}
		
		//result = "/WEB-INF/view/MemberList.jsp";
		result = "redirect:memberlist.action";
		return result;
	}
	
}
