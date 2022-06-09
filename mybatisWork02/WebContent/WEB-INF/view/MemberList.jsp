<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inital-scale=1">
<title>MemberList.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(function()
	{
		$("#submit").click(function()
		{
			//alert($("#name").val()=="");
			//alert($("#myForm"));
			/* 
			if($("#name").val()=="" || $("#telephone").val()=="")
			{
				alert("이름 혹은 전화번호를 반드시 기재해주십쇼잉");
				return;			
			}
			 */
			
			//$("#myForm").submit();
			//alert($("#myForm"));
			//alert("??");
			
			$("#myForm").submit(function()
			{
				if($("#name").val()=="" || $("#telephone").val()=="")
				{
					alert("이름 혹은 전화번호를 반드시 기재해주십쇼잉");
					return false;			
				}
			});
			
		
		
		});
		
		$(".btnDelete").click(function()
		{
			//alert("ff");
			var delMid = $(this).val();
			//alert(delMid);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result)
				location.replace("memberdelete.action?mid="+delMid);
		});
	});
</script>
</head>
<body>

<div>
	<h1>회원 정보</h1>
	<hr />
</div>

<div class="container">
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading" id="title">
				회원 정보 입력
			</div>
			
			<div class="panel-body">
				<form action="memberinsert.action" role="form" method="post" id="myForm">
					<div class="form-group">
						<label for="name">
							NAME 
						</label>
						<input type="text" class="form-control" id="name" name="name"/>
					</div>
					
					<div class="form-group">
						<label for="telephone">
							TELEPHONE
						</label>
						<input type="tel" class="form-control" id="telephone" name="telephone" />
					</div>
					
					<button type="submit"class="btn btn-default btn-sm" id="submit">SUBMIT</button>
					<button type="reset" class="btn btn-default btn-sm">CANCLE</button>
					 
				</form>
			</div>
		</div><!-- close .panel .panel-default -->
		
		<div class="panel panel-default">
			<div class="panel-heading">
				회원 정보 출력
			</div>
			
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>MID</th>
							<th>NAME</th>
							<th>TELEPHONE</th>
							<th style="text-align: center;">수정 / 삭제</th>
						</tr>
					</thead>
					<tbody>
						<!--  
						<tr>
							<td>1</td>
							<td>홍은혜</td>
							<td>010-9999-9999</td>
							<td>
								<button type="button" class="btn btn-default btn-xs btnUpdate">수정</button>
								<button type="button" class="btn btn-default btn-xs btnDelete">삭제</button>
							</td>
						</tr>
						-->
						<c:forEach var="dto" items="${list }">
							<tr>
								<td>${dto.mid }</td>
								<td>${dto.name }</td>
								<td>${dto.telephone }</td>
								<td align="center">
									<button type="button" class="btn btn-default btn-xs btnUpdate" 
									value="${dto.mid }">수정</button>
									<button type="button" class="btn btn-default btn-xs btnDelete" 
									value="${dto.mid }">삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<button type="button" class="btn btn-default btn-sm" role="badgeFrame">
					Count <span class="badge" role="badge">${count }</span>
				</button>
			</div>
		</div> 
	</div> 
</div>

</body>
</html>