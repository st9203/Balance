<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>Login</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1>Login</h1>
<hr/>
<form action="/login" method="post" autocomplete='off'>
	
	<!-- Email input -->
	  <div class="mb-4">
	  <label class="form-label" for="form1Example1">Email address</label>
	    <input type="text" id="form1Example1" name="username" class="form-control" />
	  </div>

	  <!-- Password input -->
	  <div class="mb-4">
	  <label class="form-label" for="form1Example2">Password</label>
	    <input type="password" id="form1Example2" name="password" class="form-control" />
	  </div>

    <div class="mb-4">
      <!-- Simple link -->
      <a href="/joinForm" class="btn btn-primary">Register here</a>
    </div>

	  <!-- Submit button -->
	  <button type="submit" class="btn btn-primary btn-block">Sign in</button>
	
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>