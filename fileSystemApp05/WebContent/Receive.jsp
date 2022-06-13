<%@page import="java.io.DataInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	//Receive.jsp
	
	String contentType = request.getContentType();
	Enumeration e = request.getHeaderNames();
	
	out.println("[[ 브라우저로부터 날아오는 헤더 정보들 ]] <br>");
	
	while(e.hasMoreElements())
	{
		String key = (String)e.nextElement();
		String value = request.getHeader(key);
		
		out.println(key + " " + value + "<br>");
	}
	
	out.println("[[ request 로 넘어오는 데이터들 ]] <br>");
	DataInputStream dis = new DataInputStream(request.getInputStream());
	//                                        ------------------------
	//										request 안에 바이너리로 들어오는걸 쭉 스트림 
	//                                      request 로 넘어오는 데이터들 밑에부터 한땀한땀 스트림에 들어간거
	
	String line = null;
	while( (line=dis.readLine()) != null)
	{
		//out.println(new String(line.getBytes("UTF-8"), "UTF-8") + "<br>");
		out.println(new String(line.getBytes("ISO-8859-1"), "UTF-8") + "<br>");
		//                    ------ 
		//                  바이너리형태
		// 바이너리로 열었음.
		
	}
%>