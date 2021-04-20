<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="css/Productdetail.css" rel="stylesheet">

 <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <!--  탭 부트스트랩  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div id="fullwrap">
	<jsp:include page="WEB-INF/views/include/header.jsp"></jsp:include>

<div id="productdetailName">
<h4>상품정보</h4>
<hr>
</div>


<div id="ProductTotal">
<div id="ProductPhoto">
사진들어갈 공간
</div>
<div id="Storename">
현진상점
</div>
<input id="editBtn" type="button" value="수정하기">

</div>
	
<div style='width:100%; margin:0 auto;margin-top:50px;'>
	<ul class="nav nav-tabs">
		<li class='active'><a href="#tabmenu_01" data-toggle="tab">탭메뉴1</a></li>
		<li><a href="#tabmenu_02" data-toggle="tab">탭메뉴2</a></li>
		<li><a href="#tabmenu_03" data-toggle="tab">탭메뉴3</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane fade in active" id="tabmenu_01"><p>탭메뉴1 내용</p></div>
		<div class="tab-pane fade" id="tabmenu_02"><p>탭메뉴2 내용</p></div>
		<div class="tab-pane fade" id="tabmenu_03"><p>탭메뉴3 내용</p></div>
	</div>
</div>

</div>
</body>
</html>