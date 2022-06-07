<<<<<<< HEAD
/*==========================================================
	#26. EmployeeUpdateFormController.java
=======
/* =================================
	EmployeeUpdateFormController.java
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	- 사용자 정의 컨트롤러 클래스
	- 직원 데이터 수정 폼 요청에 대한 액션 처리
	- DAO 객체에 대한 의존성 주입(DI)을 위한 준비 필요
	  → 인터페이스 형태의 자료형을 속성으로 구성
	  → setter 메소드 구성
<<<<<<< HEAD
==========================================================*/
=======
================================= */
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 『Controller』 인터페이스를 구현하는 방법을 통해
//    사용자 정의 컨트롤러 클래스를 구성한다.

public class EmployeeUpdateFormController implements Controller
{
<<<<<<< HEAD
	// check~!!!
	// EmployeeInsertFormController 구성과는 다른 방식으로 처리~!!!
	// ----------------------------
	//  → 필요한 모든 메소드를 EmplyeeDAO 에 정의해 두었던 상태
=======
	//check~!!
	//EmployeeInsertFormController 구성과는 다른 방식으로 처리!
	//---------------------------------------------------------
	//→ 필요한 모든 메소드가 EmployeeDAO 에 정의해 두었던 상태
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	
	private IEmployeeDAO employeeDAO;
	private IRegionDAO regionDAO;
	private IDepartmentDAO departmentDAO;
	private IPositionDAO positionDAO;
	
<<<<<<< HEAD
	// setter 구성
=======
	
	//setter 구성

>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	public void setEmployeeDAO(IEmployeeDAO employeeDAO)
	{
		this.employeeDAO = employeeDAO;
	}
<<<<<<< HEAD
=======

>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	public void setRegionDAO(IRegionDAO regionDAO)
	{
		this.regionDAO = regionDAO;
	}
<<<<<<< HEAD
=======

>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	public void setDepartmentDAO(IDepartmentDAO departmentDAO)
	{
		this.departmentDAO = departmentDAO;
	}
<<<<<<< HEAD
=======

>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	public void setPositionDAO(IPositionDAO positionDAO)
	{
		this.positionDAO = positionDAO;
	}


<<<<<<< HEAD
=======

>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 컨트롤러가 수행하는 액션 코드
<<<<<<< HEAD
		ModelAndView mav = new ModelAndView();
		
		// 로그인 여부만 확인 → 관리자인지 확인할 필요 없음.
		// 세션 처리과정 추가 -----------------------------------------------------------------------
		HttpSession session = request.getSession();
		
		if (session.getAttribute("name")==null)	//-- 로그인이 되어 있지 않은 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		//-----------------------------------------------------------------------  세션 처리과정 추가 
		
=======
		
		ModelAndView mav = new ModelAndView();
		
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
		ArrayList<Region> regionList = new ArrayList<Region>();
		ArrayList<Department> departmentList = new ArrayList<Department>();
		ArrayList<Position> positionList = new ArrayList<Position>();
		
		try
		{
			// 데이터 수신 (EmployeeList.jsp 로 부터... employeeId 수신)
			String employeeId = request.getParameter("employeeId");
			
			Employee employee = new Employee();
			
			employee = employeeDAO.searchId(employeeId);
			
			regionList = regionDAO.list();
			departmentList = departmentDAO.list();
			positionList = positionDAO.list();
			
<<<<<<< HEAD
=======
			
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
			mav.addObject("employee", employee);
			mav.addObject("regionList", regionList);
			mav.addObject("departmentList", departmentList);
			mav.addObject("positionList", positionList);
			
			mav.setViewName("/WEB-INF/view/EmployeeUpdateForm.jsp");
			
<<<<<<< HEAD
=======
			
>>>>>>> 7172f3411ee4395078d2dd857f4c079bf3fac059
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}
	
}
