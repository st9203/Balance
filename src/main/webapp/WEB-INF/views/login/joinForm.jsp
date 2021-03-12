<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>회원가입</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1> 회원가입</h1>
<hr>
<form action="/join" method="post">
	<input type="text" name="username" placeholder="Username" />
	<input type="password" name="password" placeholder="PassWord" />
	<input type="email" name="email" placeholder="Email" />
	<button>회원가입</button>
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>