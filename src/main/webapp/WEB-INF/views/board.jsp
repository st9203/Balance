<%@ include file="common/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form action="/board/search" method="get">

<div class="d-flex flex-row-reverse bd-highlight">
	<div class="p-2 bd-highlight">
		<button class="btn btn-success">검색</button>
	</div>
	<div class="p-2 bd-highlight">
		<input type="text" name="search" class="form-control" />	
	</div>
</div>

</form>

<table class="table table-striped table-hover">

	<tr>
		<th>No</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>시간</th>
	</tr>
	
	<c:forEach var="list" items="${boards}" >
		<tr>
		
			<td>${list.no }</td>
			<td>${list.title }</td>
			<td>${list.content }</td>
			<td>${list.auth }</td>
			<td><fmt:formatDate value="${list.day }" pattern="yyyy.MM.dd" /></td>
		
		</tr>
	</c:forEach>
</table>
<!-- <div class="d-flex flex-row-reverse bd-highlight"> -->
<!-- 	<div class="p-2 bd-highlight"> -->
<!-- 		<a href="/board/write" class="btn btn-primary">작성</a> -->
<!-- 	</div> -->
<!-- </div> -->

<!-- <nav aria-label="Page navigation example"> -->
<!--   <ul class="pagination"> -->
<!--     <li class="page-item"> -->
<!--       <a class="page-link" href="#" aria-label="Previous"> -->
<!--         <span aria-hidden="true">&laquo;</span> -->
<!--       </a> -->
<!--     </li> -->
<%-- <%--     <c:forEach > --%> --%>
    
<!--     <li class="page-item"><a class="page-link" href="#">1</a></li> -->
<!--     <li class="page-item"><a class="page-link" href="#">2</a></li> -->
<!--     <li class="page-item"><a class="page-link" href="#">3</a></li> -->
<!--     <li class="page-item"> -->
<!--       <a class="page-link" href="#" aria-label="Next"> -->
<!--         <span aria-hidden="true">&raquo;</span> -->
<!--       </a> -->
<!--     </li> -->
<!--   </ul> -->
<!-- </nav> -->


<%-- <c:set var="page" value="${(param.p == null) ? 1 : param.p}"/> --%>
<%-- <c:set var="startPage" value="${page - (page-1) % 5 }"/> --%>
<%-- <c:set var="endPage" value="23"/>	 --%>
<%-- <c:set var="isLast" value="4" /> --%>
 
<div>
	<c:if test="${startPage >= 6 }">
		<a href="?p=${startPage - 5 }&t=&q=" class="btn btn-prev">이전</a>
	</c:if>
	<!--<c:if test="${startPage == 0}">
		<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
	</c:if>
        -->
	
</div>


<%-- <!-- 직전 -1 으로 보내는 경우 -->
<div>
	<c:if test="${startPage - 1 > 0 }">
		<a href="?p=${startPage - 1 }&t=&q=" class="btn btn-prev">이전</a>
	</c:if>
	<c:if test="${startPage <= 0}">
		<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
	</c:if>
	
</div>  --%>


<ul class="-list- center">
	<c:if test="${startPage + 5 >= endPage }">
		<c:set var="isLast" value="${endPage - startPage }" />	
	</c:if>

		<c:forEach var="i" begin="0" end="${isLast }">
			<li><a class="-text- orange bold" href="?p=${startPage + i}&t=&q=" >${startPage + i}</a></li>
		</c:forEach>			
	
</ul>
<div>
<!-- 마지막번호는 DB레코드 수와 연관이 있다!
     우선은 lastpage 개수를 임의로 지정. -->
	<c:if test="${startPage + 5 < endPage }">
		<a href="?p=${startPage + 5}&t=&q=" class="btn btn-next">다음</a>
	</c:if>
	<%-- <c:if test="${startPage + 5 >= endPage }">
		<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
	</c:if> --%>
	
</div>
<%@include file="common/footer.jsp"%>