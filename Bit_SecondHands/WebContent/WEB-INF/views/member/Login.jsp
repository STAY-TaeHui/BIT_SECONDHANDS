<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/Registercss.css" rel="stylesheet">
​
</head>
​
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
​
	<div class="container_a">
		<br>
		<div>
			<article class="card-body mx-auto" style="max-width: 400px;">
				<p class="divider-text" style="text-align: center;">
					<img src="images/logo.gif">
				</p>
				<br>
				<form>
					<div>
						<h5>ID</h5>
							<input id="email" name="email" class="form-control"
								placeholder="이메일" type="email">
							<div>
						</div>
					</div>
					<br>
​
​
					<div>
						<div>
							<h5>비밀번호</h5>
						</div>
						<input name="passward" class="form-control"
							placeholder="영문자, 숫자, 특수문자 조합으로 입력하세요" type="password">
					</div>
					<br>
​
​
				</form>
				<div>
					<input class="form-control" type="submit" id="loginBtn" value="로그인">
				</div>
				<div class="form-control" id="look_book">
					<a href="findid">아이디찾기 | </a> <a href="findpassword">비밀번호찾기 | </a> <a href="Register.do">회원가입</a>
​
				</div>
​
			</article>
		</div>
		<!-- card.// -->
​
	</div>
	<!--container end.//-->
</body>
</html>