<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	//FileRead.jsp
	
	String appRoot = "/";
	appRoot = pageContext.getServletContext().getRealPath(appRoot);
	
	// 1. 파일을 읽기 위해 File 객체를 생성
	//    쓸 때 뿐만 아니라 읽을 때도 객체 생성해야함!
	File newFile = new File(appRoot, "data/test.txt");
	
	// 2. 파일이 존재하는지의 여부 확인
	//    → 파일이 존재하는 경우에만 처리하여 FileNotFoundException 방지
	if ( newFile.exists() )
	{
		// 3-1. 파일을 읽기 위한 FileReader 객체 생성
		FileReader fr = new FileReader(newFile);
		
		// 3-2. FileReader 를 조금 더 효율적으로 읽어내기 위해 BufferedReader 로 감싸기
		BufferedReader br = new BufferedReader(fr);
		//------------
		// 버퍼가 달림 : 한줄 한줄
		// 이게 아니면 문자기반으로 하나하나 읽어.
		
		// 4. 실질적으로 파일의 내용을 읽어냄.
		String readData;
		while( (readData=br.readLine())!=null )
		{
			out.println(readData + "<br>" );
		}
		
		// 5-1. BufferedReader 리소스 반납(닫아줌)
		br.close();
		
		// 5-2. FileReader 리소스 반납(닫아줌)
		fr.close();
	}
	
	

%>
