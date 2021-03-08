<%@ include file="common/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<main class="px-3">
		<h1>테마를 골라주세요</h1>
		<form action="/game/start" method="get">
		<div class="input-group mb-3">
			<select class="form-select" id="theme" name="theme">
				<option value="food">음식</option>
				<option value="sex">이성</option>
				<option value="thing">물건</option>
				<option value="ability">능력</option>
			</select> <label class="input-group-text" for="theme">테마</label>
		</div>


		<button type="submit">게임 시작</button>
		</form>
	</main>
</div>

<%@include file="common/footer.jsp"%>