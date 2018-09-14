<%@page import="kr.or.connect.Todo.dto.TodoDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String[] todoTypes = {"TODO", "DOING", "DONE"};
	request.setAttribute("todoTypes", todoTypes);
%>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css?ver=1" rel="stylesheet" type="text/css">
<title>TODO 리스트</title>
</head>
<body>
	<content>
	<form method="post" action="todoForm">
		<header>
		<h1>
			<br>나의 해야할 일들
		</h1>
		<button id="new" type="submit">새로운 TODO 등록</button>
		</header>
	</form>

	<section style="overflow: auto; clear: both; position: relative;">
		<section id="outline">
			<c:forEach var="todoType" items="${todoTypes}">
   				<div id="${todoType}" class="list">
     			 <ul>
         			<li class="state">${todoType}</li>
         			<c:forEach var="list" items="${todoList}">
						<c:if test="${todoType eq list.type}">
	    					<li>
								<p>${list.title }</p>
								<div style="width: 210px;">등록날짜:${list.regdate },
									${list.name },
									우선순위 ${list.sequence }
								</div>
								<c:if test="${'DONE' ne todoType}">
									<input type="button" id="next" value="&rarr;" onclick="clicked(${list.id },this)" >
								</c:if>
	    					</li>
						</c:if>
        			</c:forEach>
				</ul>
				</div>
			</c:forEach>
		</section>
	</section>
	</content>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>
