<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
<link href="css/Registercss.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<link href="css/indexCSS.css">
<script type="text/javascript" src="js/Registerjs.js"></script>

<!-- jQuery -->
<!-- iamport.payment.js -->
</head>

<body>

	<div class="container">
		<br>
		<div>
			<article class="card-body mx-auto" style="max-width: 400px;">
				<p class="divider-text" style="text-align: center;">
					<img src="images/logo.gif">
				</p>
				<br>
				<form id="form">
					<div>
						<h5>ID</h5>
						<div class="input-group-prepend" id="shopname">
							<input type="text" name="email" id="email" style="width: 150px"
								placeholder="이메일" class="form-control"> @ <input
								type="text" name="emailType" id="emailType"
								style="width: 85px; margin-left: 5px" disabled value="naver.com"
								class="form-control"> <select
								style="width: 85px; margin-right: 10px" name="selectEmail"
								id="selectEmail">
								<option value="1">직접입력</option>
								<option value="naver.com" selected>naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="hotmail.com">hotmail.com</option>
								<option value="nate.com">nate.com</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="empas.com">empas.com</option>
								<option value="dreamwiz.com">dreamwiz.com</option>
								<option value="freechal.com">freechal.com</option>
								<option value="lycos.co.kr">lycos.co.kr</option>
								<option value="korea.com">korea.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hanmir.com">hanmir.com</option>
								<option value="paran.com">paran.com</option>
							</select>
							<button type="button" id="emailCheckBtn">중복체크</button>
						</div>
					</div>
					<br>
					<div>
						<div>
							<h5>비밀번호</h5>
						</div>
						<input id="password" name="password" class="form-control"
							placeholder="영문자, 숫자, 특수문자 조합으로 입력하세요" type="password">
					</div>
					<br>

					<div>
						<div>
							<h5>비밀번호 확인</h5>
						</div>
						<input id="passwordC" name="passwordC" class="form-control"
							placeholder="입력한 비밀번호와 동일하게 입력해주세요" type="password">
						<div id="passswordCheckDiv"></div>
					</div>
					<br>

					<div>
						<div>
							<h5>이름</h5>
						</div>
						<input class="form-control" placeholder="" type="text" name="name"
							id="name">
					</div>
					<br>

					<div>
						<div>
							<h5>닉네임 / 상점이름</h5>
						</div>
						<div id="shopname">
							<input id="shopName" name="shopname" class="form-control"
								placeholder="" type="text">
							<button type="button" id="nameCheckBtn">중복체크</button>
						</div>
					</div>
					<br>

					<div>
						<div>
							<h5>핸드폰 번호</h5>
						</div>
						<div id="shopname">
							<input id="phone" class="form-control"
								placeholder="11자리 숫자로 입력하세요" type="text">
							<button type="button" id="phoneCheckBtn">전번인증</button>
						</div>
					</div>
					<br>

					<!-- form-group// -->

					<!-- form-group// -->
				</form>
				<div>
					<input class="form-control" type="button" id="submitBtn"
						value="가입하기">
				</div>
			</article>
		</div>
		<!-- card.// -->

	</div>
	<!--container end.//-->
</body>
<script type="text/javascript">
	//이메일 입력방식 선택
	$('#selectEmail').change(function() {
		$("#selectEmail option:selected").each(function() {
			if ($(this).val() == '1') { //직접입력일 경우
				$("#emailType").val(''); //값 초기화
				$("#emailType").attr("disabled", false); //활성화
			} else { //직접입력이 아닐경우
				$("#emailType").val($(this).text()); //선택값 입력
				$("#emailType").attr("disabled", true); //비활성화
			}
		});
	});

	//이메일 중복체크
	$('#emailCheckBtn').click(function() {
		let email = $('#email').val();
		let emailType = $('#emailType').val();
		console.log(email + "@" + emailType);
		if (email == '') {
			swal({
				title : "이메일을 입력해주세요",
				icon : "error"
			});
			return;
		}
		$.ajax({
			url : "EmailCheckOk.ajax",
			data : {
				email : email + "@" + emailType
			},
			type : "get",
			dataType : "html",
			success : function(data) {
				console.log(data);
				if (data == 'true') {
					swal({
						title : "사용가능한 이메일입니다",
						icon : "success"
					});
				} else {
					swal({
						title : "이미 존재하는 이메일입니다",
						icon : "error"
					});
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	});
	
	//닉네임 / 상점이름 중복체크
	$('#nameCheckBtn').click(function() {
		let shopname = $('#shopName').val();
		console.log(shopname);
		
		if (shopname == '') {
			swal({
				title : "닉네임 / 상점이름을 입력해주세요",
				icon : "error"
			});
			return;
		}
		
		$.ajax({
			url : "NameCheckOk.ajax",
			data : {
				storename : shopname
			},
			type : "get",
			dataType : "html",
			success : function(data) {
				console.log(data);
				if (data=='true') {
					swal({
						title : "사용가능한 상점이름 입니다",
						icon : "success"
					});
				} else {
					swal({
						title : "이미 존재하는 상점이름 입니다",
						icon : "error"
					});
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	});
</script>
</html>