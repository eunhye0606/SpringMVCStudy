<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	//Test_ok.jsp
	
	//                                 ↓        예전 방식
	//String root = request.getRealPath("/")
	String root = pageContext.getServletContext().getRealPath("/");
	//String savaPath = root + File.separator + "pds" + "\\" + "saveFile";
	String savePath = root + "pds" + "\\" + "saveFile";	//-- 저장되는 파일 루트 pds 폴더안에 savaFile
	File dir = new File(savePath);	//-- 생성만 한거지 파일 만들어진건 아님.
	
	//테스트
	System.out.println(savePath);
	//C:\SpringMVCStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\fileSystemApp06\\pds\saveFile
	
	if(!dir.exists())
	{
		dir.mkdirs();
	}
	
	String encType = "UTF-8";	//--인코딩 방식
	int maxFileSize = 5*1024*1024;	//--최대 업로드 크기, 제한 안하면 서비스 제대로 제공 못할 수 있다.
	//                --------- 5MB
	
	
	try
	{
		MultipartRequest multi = null;
		//-------------- cos.jar
		multi = new MultipartRequest(request, savePath, maxFileSize
									, encType , new DefaultFileRenamePolicy());
		// 우리가 직접 request 컨트롤해도 얻는건 null 이기 때문에
		// multipartrequest에게 파라미터 준다. 그러면 바이너리 단위도 컨트롤 가능
		// savePath 저장
		// 최대업로드 크기
		// 인코딩방식
		// 같은 이름 파일 덮어쓸지, 어떻게할지 정책
		// 기본형태 옵션안주면 같은 이름 파일 숫자만 추가해서 저장
		
		out.println("작성자 : " + multi.getParameter("userName") + "<br>");
		out.println("제목 : " + multi.getParameter("subject") + "<br>");
		out.println("서버에 저장된 파일명 : " + multi.getFilesystemName("uploadFile") + "<br>");
		out.println("업로드한 파일명 : " + multi.getOriginalFileName("uploadFile")+ "<br>");
		out.println("파일 타입 : " + multi.getContentType("uploadFile") + "<br>");
		
		File file = multi.getFile("uploadFile");
		if(file != null)
		{
			out.println("파일 크기 : " + file.length()+ "<br>");
		}
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
%>

