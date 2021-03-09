<%@ include file="common/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form action="/board/insert" method="post">
  <div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" class="form-control" id="title"name="title" placeholder="제목을 작성해주세요.">
</div>
<div class="mb-3">
  <label for="content" class="form-label">내용</label>
  <textarea class="form-control" id="content" name= content rows="3"></textarea>
</div>
  <button type="submit" class="btn btn-primary">작성완료</button>
</form>

	
<%@include file="common/footer.jsp"%>