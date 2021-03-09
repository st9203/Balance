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

	<c:forEach var="list" items="${boards.content}">
		<tr>

			<td>${list.no }</td>
			<td><a href="/board/detail?no=${list.no}">${list.title }</td>
			<td>${list.content }</td>
			<td>${list.auth }</td>
			<td><fmt:formatDate value="${list.day }" pattern="yyyy.MM.dd" /></td>

		</tr>
	</c:forEach>
</table>
<div class="d-flex flex-row-reverse bd-highlight">
	<div class="p-2 bd-highlight">
		<a href="/board/write" class="btn btn-primary">작성</a>
	</div>
</div>

<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first }">
				<li class="page-item disabled">
				<a class="page-link " href="?page=${boards.number-1 }" aria-label="Previous"> 
					<span aria-hidden="true">Previous</span>
				</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item">
				<a class="page-link" href="?page=${boards.number-1 }" aria-label="Previous"> 
					<span aria-hidden="true">Previous</span>
				</a>
				</li>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${boards.last }">
				<li class="page-item disabled">
		<a class="page-link " href="?page=${boards.number+1 }" aria-label="Next"> 
		<span aria-hidden="true">NEXT</span>
		</a></li>
			</c:when>
	<c:otherwise>
		<li class="page-item">
		<a class="page-link" href="?page=${boards.number+1 }" aria-label="Next"> 
		<span aria-hidden="true">NEXT</span>
		</a></li>
	
	</c:otherwise>		
		</c:choose>
	</ul>
</nav>



<%@include file="common/footer.jsp"%>