<%@ include file="common/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">



	<div style="color:#ccc">
		글 번호 : <span id="id"><i>${board.no }</i></span>
		작성자  : <span><i>${board.auth }</i></span>
	</div>

	<div class="form-group">
		${board.title }
	</div>
	<hr>
	<div class="form-group">
		${board.content }
	</div>
	<hr>
	<br><br>
	<button type="button" onclick="history.back();" class="btn btn-secondary">Back</button>
	<a href="/board/del?no=${board.no }" class="btn btn-warning">Modify</a>
	<a href="/board/del?no=${board.no }" class="btn btn-danger">Remove</a>
</div>

<%@include file="common/footer.jsp"%>