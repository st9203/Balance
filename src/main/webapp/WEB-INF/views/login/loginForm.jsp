<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>로그인</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1> 로그인</h1>
<hr>
<form action="/login" method="post">
	<input type="text" name="username" placeholder="Username" />
	<input type="password" name="password" placeholder="PassWord" />
	
	<br>
	<button>로그인</button>
	<br>
	<a href="/joinForm">회원가입</a>
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>