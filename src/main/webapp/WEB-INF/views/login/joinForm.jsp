<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>Register</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1>Register</h1>
<hr>
<form name="joinForm" autocomplete='off'>
	<!-- Email input -->
	  <div class="mb-3">
	    <label class="form-label" for="email">Email address</label>
	    <input type="email" id="email" name="email" class="form-control" />
	  </div>

	  <!-- username input -->
	  <div class="mb-3">
		  <label class="form-label" for="username">Username</label>
		  <input type="text" id="username" name="username" class="form-control" />
		  <button type="button" class="btn btn-primary btn-block" name="checkUsername" onclick="checkDuplication();">Check</button>
		  <span id="checkIdSpan" style="display:none;"></span>
		  <input type="hidden" id="checkIdYn" value="N"/>
	  </div>
	  
	  <!-- Password input -->
	  <div class="mb-3">
	  <label class="form-label" for="password">Password</label>
	  <input type="password" id="password" name="password" class="form-control pw" />
	  </div>

	  
	  <!-- Check Password input -->
	  <div class="mb-3">
	    <label class="form-label" for="checkPw">Check Password</label>
	    <input type="password" id="checkPw" name="checkPw" class="form-control pw" />
	  </div>

	  <div class="alert alert-danger" id="validationArt" role="alert" style="display:none;">
	  
	  </div>
	  
	  <!-- Submit button -->
	  <button type="button" onClick="join()" class="btn btn-primary btn-block">Register</button>
	
</form>
<script>


function join(){
	var pass = false;
	pass = validation();
	console.log('pass : ' + pass);
	if(pass) {
		var form = $("form[name=joinForm]").serialize() ;
		
		$.ajax({
			type : 'post',
			url : '/join',
			data : form,
			error: function(xhr, status, error){
				alert(error);
				console.log(error)
			},
			success : function(res){
				console.log(res)
				if(res == 'success'){
					location.href='/loginForm'
				}else{
					alert('오류발생');
				}
			}
		});
	}

}

function checkDuplication(){
	var username = $("input[name=username]").val() ;
	console.log(username)
	if(username!=""){
		$.ajax({
			type : 'post',
			url : '/checkId',
			data : {'username':username},
			dataType: "text",
			error: function(xhr, status, error){
				alert(error);
			},
			success : function(res){
				console.log(res)
				if(res == 0){
					$("#checkIdSpan").text('사용가능한 아이디입니다.');
					$("#checkIdSpan").css('display','');
					$("#checkIdYn").val('Y')
				}else{
					$("#checkIdSpan").text('이미 사용중인 아이디입니다.');
					$("#checkIdSpan").css('display','');
					$("#username").focus();
				}
			}
		});
	}else{
		$("#username").focus();
		alert('Username을 입력해 주세요');
		return false;
	}
}



function validation() {
	 if($("#password").val() != $("#checkPw").val()) {
		 $("#validationArt").text('비밀번호가 일치하지 않습니다.');
		 $("#validationArt").css("display","");
		 return false;
	 }
	 if($("#checkIdYn").val() != 'Y'){
		 alert('중복되는 아이디가 있습니다.');
		 return false;
	 }
	 return true;
	 
}
	
	
	$(".pw").focusout(function(){
		var pw = $("#password").val();
		var cpw = $("#checkPw").val();
		
		if(pw != '' && cpw != '') {
			
		}else if(pw != '' || cpw != '') {
			if(pw != cpw) {
				$("#validationArt").text('비밀번호가 일치하지 않습니다.');
				$("#validationArt").css("display","");
			}else {
				$("#validationArt").css("display","none");
			}
		}
	});
	
	</script>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>