/* ==================================
	MemberMain.java
	- mybatis 객체 활용(Controller)
================================== */
package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberMain
{
	// 주요 속성 구성
	// 실제 연결부터해서 쿼리문을 실행하는 sqlsession이 필요.
	// 프레임워크 핵심 : 만든걸 규칙적, 환경에서 제공하는 바구니에 딸깍 끼워서 맞아준다는 얘기.
	// 이 컨트롤러가 리스트 / 데이터 입력 / 인원수 조회를 해줘야함.
	
	//mybatis 객체 의존성(자동) 주입~!!!
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/memberlist.action", method = RequestMethod.GET)
	public String memberList(ModelMap model) //Model도 사용 가능. 같은거
	{
		//원래는 이렇게 함.
		//IMemberDAO dao = (IMemberDAO)new MemberDAO();
		
		
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		//sqlSession의 매퍼가 따라할 인터페이스를 파라미터로 넘겨
		
		//dao.count();
		//dao.list();
		
		model.addAttribute("count", dao.count());
		model.addAttribute("list", dao.list());
		
		
		return "WEB-INF/view/MemberList.jsp";
	}
	@RequestMapping(value = "/memberinsert.action", method = RequestMethod.POST)
	public String memberInsert(MemberDTO m)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		dao.add(m);
		
		return "redirect:memberlist.action";
	}
	
	@RequestMapping(value = "/memberdelete.action", method = RequestMethod.GET)
	public String memberDelete(String mid)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		dao.del(mid);
		return "redirect:memberlist.action";
	}
	

}
