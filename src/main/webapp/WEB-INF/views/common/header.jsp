<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<!-- Favicons -->
<link rel="apple-touch-icon" href="https://getbootstrap.com/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://getbootstrap.com/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://getbootstrap.com/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://getbootstrap.com/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://getbootstrap.com/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="https://getbootstrap.com/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">
<style>
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}
</style>

<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
 
 
 // 하이라이트 처리
 $(document).ready(function(){
 
 	var pathName = $(location).attr('pathname').split('/');
 	
 	var url = pathName[2];

 	if(url == 'data'){

		$('nav a:eq(1)').addClass('active');
	
	}else if(url == 'chat'){
	
		$('nav a:eq(2)').addClass('active');
	
	}else if(url == 'maps'){

		$('nav a:eq(3)').addClass('active');

	}else if(url == 'board'){

		$('nav a:eq(4)').addClass('active');

	}else {
		$('nav a:eq(0)').addClass('active');
	}
	
 });
	

</script>
<link href="/css/cover.css"	rel="stylesheet">
<title>Balance</title>
</head>
<body class="d-flex h-100 text-center text-white bg-dark">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column container">

		<header class="mb-auto">
			<div>
				<h3 class="float-md-start mb-0">Balance</h3>
				<nav class="nav nav-masthead justify-content-center float-md-end">
					<a class="nav-link" id="index" href="/balance/index">Home</a> <a
						class="nav-link" id="index" href="/balance/data">Data</a> <a
						class="nav-link" id="index" href="/balance/chat">Chat</a> <a
						class="nav-link" id="index" href="/balance/maps">Maps</a> <a
						class="nav-link" id="index" href="/balance/board">Board</a>
				</nav>
			</div>
		</header>
		
	<!-- 	<div class="container m-5"> -->