<%@ include file="common/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<main class="px-3">
		<div class="input-group mb-5" style="height:200px;">
			<form action="/data/insert" method="POST" class="form-controller">
				<div class="input-group flex-nowrap">
					<span class="input-group-text" id="addon-wrapping">조건</span> 
					<input	type="text" class="form-control" placeholder="ex) 무조건 먹어야한다면"	name="ifMoon" aria-describedby="addon-wrapping">
				</div>
					<br>


		<div class="d-flex justify-content-between">
				<div class="input-group flex-nowrap">
					<span class="input-group-text" id="addon-wrapping">A</span> 
					<input	type="text" class="form-control" placeholder="ex) 토맛 토마토"	name="A" aria-describedby="addon-wrapping">
				</div>

	  
	
				<div class="input-group flex-nowrap">
					<span class="input-group-text" id="addon-wrapping">B</span> 
					<input	type="text" class="form-control" placeholder="ex) 토마토맛 토"	name="B" aria-describedby="addon-wrapping">
				</div>
</div>


				<br>
				
				<div class="input-group mb-3">
					<select class="form-select" id="theme" name="theme">
						<option value="food">음식</option>
						<option value="sex">이성</option>
						<option value="thing">물건</option>
						<option value="ability">능력</option>
					</select> <label class="input-group-text" for="theme">테마</label>
				</div>

				<br>
				<button type="submit" class="btn btn-light center">저장</button>
			</form>
		</div>
	</main>
</div>

<%@include file="common/footer.jsp"%>