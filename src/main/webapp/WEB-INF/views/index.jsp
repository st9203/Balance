<%@ include file="common/header.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 		<main class="px-3"> -->
<!-- 			<h1 >게임은</h1> -->
 			<p class="lead">TEST</p>
<!-- 			<p class="lead"> -->
<!-- 				<a href="#" class="btn btn-lg btn-secondary fw-bold border-white bg-white">준비중입니다.</a> -->
<!-- 			</p> -->
<!-- 		</main> -->
<form name="form" method="post" action="http://localhost:8080/board" enctype="multipart/form-data">
      <input name="user" value="Pyo"/>
      <input name="content" value="Content"/>
      <c:if test=""></c:if>
      <img src="/img/${imgName }">
      <input type="file" name="files" multiple="multiple"/>
      <input type="submit" id="submit" value="전송"/>
</form>


<%@include file="common/footer.jsp" %>