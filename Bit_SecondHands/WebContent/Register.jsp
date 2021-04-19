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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
							<input id="email" name="email" class="form-control"
								placeholder="이메일" type="email"> <select
								class="custom-select"
								style="max-width: 140px; margin-right: 10px;">
								<option value="@naver.com">@naver.com</option>
								<option value="@gmail.com">@gmail.com</option>
								<option value="@daum.net">@daum.net</option>
								<option value="@nate.com">@nate.com</option>
							</select>
							<div>
								<button type="button" id="idCheckBtn"
									style="height: 38px; width: 75px; font-size: 12px;">중복체크</button>
							</div>
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
						<input class="form-control" placeholder="" type="text" name="name" id="name">
					</div>
					<br>

					<div>
						<div>
							<h5>닉네임 / 상점이름</h5>
						</div>
						<div id="shopname">
							<input id="shopName" name="shopname" class="form-control" placeholder="" type="text">
							<button type="button" id="CheckBtn"
								style="width: 80px; font-size: 12px;">중복체크</button>
						</div>
					</div>
					<br>

					<div>
						<div>
							<h5>핸드폰 번호</h5>
						</div>
						<div id="shopname">
							<input id="phone" class="form-control" placeholder="11자리 숫자로 입력하세요"
								type="text">
							<button type="button" id="phoneCheckBtn"
								style="width: 80px; font-size: 12px;">전번인증</button>
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
</html>