<%@ include file="common/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	function chk(){
	var form = document.form;
	var title = document.form.title.value;
	var content = document.form.content.value;
		if(title == "" || title == null){
			alert('제목이 비어있습니다.');
			document.form.title.focus();
			return false;
		}else if(content == "" || content == null){
			alert('내용이 비어있습니다.');
			document.form.content.focus();
			return false;
		}else{
		alert('수정 완료!');
		return form.submit();
		}
	}
</script>

	<form action="/balance/board/modify" name="form" method="post">
	<input type="hidden" value="${board.no }" name="no" />
		<div class="mb-3">
			<label for="title" class="form-label">제목</label> 
			<input type="text" class="form-control" id="title" name="title" value="${board.title }" placeholder="제목을 작성해주세요.">
		</div>
		<div class="mb-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" id="content" name=content rows="3">${board.content}</textarea>
		</div>
		<button type="button" onclick="chk();" class="btn btn-primary">수정완료</button>
	</form>

<%@include file="common/footer.jsp"%>