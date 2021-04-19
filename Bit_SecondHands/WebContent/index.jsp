<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<<<<<< HEAD
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fashi | Template</title>

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

    <!--j쿼리 cdn-->
    <script  src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!--검색어 자동완성 j쿼리-->
    <!-- CSS , JS -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- 검색을 위한 한글 자모분리 js-->
    <script src="https://unpkg.com/hangul-js" type="text/javascript"></script>
    <script type="text/javascript" src="js/hangul.js"></script>
    <script>

        
        $(function() {    //화면 다 뜨면 시작
            


            /* 검색어 자동완성 기능(미완성)
            $("#header_search").autocomplete({
                source : function( request, response ) {
                    $.ajax({
                            type: 'get',
                            url: "a.ajax",
                            dataType: "json",
                            //data: {"param":"param"},
                            success: function(data) {
                                //서버에서 json 데이터 response 후 목록에 추가
                                response(
                                    $.map(data, function(item) {    //json[i] 번째 에 있는게 item 임.
                                        return {
                                            label: item+"label",    //UI 에서 보여지는 글자, 실제 검색어랑 비교 대상
                                            value: item,    //그냥 사용자 설정값?
                                            test : item+"test"    //이런식으로 사용

                                            //[
                        //    {"name": "하늘이", "dogType": "푸들", "age": 1, "weight": 2.14},
                            //    {"name": "콩이", "dogType": "푸들", "age": 3, "weight": 2.5},
                            //    {"name": "람이", "dogType": "허스키", "age": 7, "weight": 3.1}
                            //]
                                            // json이 다음 처럼 넘어오면
                                            // 상황 : name으로 찾고 dogType을 넘겨야 하는 상황이면 
                                            // label : item.dogType ,    //오토컴플릿이 되고 싶은 단어 
                                            // value : item.family ,    //넘겨야 하는 단어
                                            // age : item.age ,
                                            // weight : item.weight
                                        }
                                    })
                                );
                            }
                    });
                    },    // source 는 자동 완성 대상
                select : function(event, ui) {    //아이템 선택시
                    console.log(ui);//사용자가 오토컴플릿이 만들어준 목록에서 선택을 하면 반환되는 객체
                    console.log(ui.item.label);    //김치 볶음밥label
                    console.log(ui.item.value);    //김치 볶음밥
                    console.log(ui.item.test);    //김치 볶음밥test
                    
                },
                focus : function(event, ui) {    //포커스 가면
                    return false;//한글 에러 잡기용도로 사용됨
                },
                minLength: 1,// 최소 글자수
                autoFocus: true, //첫번째 항목 자동 포커스 기본값 false
                classes: {    //잘 모르겠음
                    "ui-autocomplete": "highlight"
                },
                delay: 500,    //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
    //            disabled: true, //자동완성 기능 끄기
                position: { my : "right top", at: "right bottom" },    //잘 모르겠음
                close : function(event){    //자동완성창 닫아질때 호출
                    console.log(event);
                }
            });
            
            //한글검색 비동기
            $.ajax({
                type : 'get',
                url : "/json",
                dataType : "json",
                //request.term = $("#autocomplete").val()
                //data: {"param":"param"},
                success : function(data) {
                    //현재 data 상태
                    //data = ["김치 볶음밥","신라면","진라면","라볶이","팥빙수","너구리","삼양라면","안성탕면","불닭볶음면","짜왕","라면사리"];
                    
                    //이부분이 초성 검색이 가능하게 만들어 주는 부분
                    let source = $.map(data, function(item) { //json[i] 번째 에 있는게 item 임.
                        chosung = "";
                        //Hangul.d(item, true) 을 하게 되면 item이 분해가 되어서 
                        //["ㄱ", "ㅣ", "ㅁ"],["ㅊ", "ㅣ"],[" "],["ㅂ", "ㅗ", "ㄲ"],["ㅇ", "ㅡ", "ㅁ"],["ㅂ", "ㅏ", "ㅂ"]
                        //으로 나오는데 이중 0번째 인덱스만 가지고 오면 초성이다.
                        Hangul.d(item, true).forEach(function(strItem, index) {
                            if(strItem[0] != " "){	//띄어 쓰기가 아니면
                                chosung += strItem[0];//초성 추가
                            }
                        });
                        return {
                            label : chosung + "|" +item, //실제 검색어랑 비교 대상 ㄱㅊㅂㅇㅂ|김치 볶음밥 이 저장된다.
                            value : item, //김치 볶음밥
                            chosung : chosung	//ㄱㅊㅂㅇㅂ
                        }
                    });
                    
                    
                    $("#searchInput").autocomplete({
                        source : source,	// source 는 자동 완성 대상
                        select : function(event, ui) {	//아이템 선택시
                            console.log(ui.item.label + " 선택 완료");	
                            
                        },
                        focus : function(event, ui) {	//포커스 가면
                            return false;//한글 에러 잡기용도로 사용됨
                        }
                    }).autocomplete( "instance" )._renderItem = function( ul, item ) {	
                    //.autocomplete( "instance" )._renderItem 설절 부분이 핵심
                    return $( "<li>" )	//기본 tag가 li로 되어 있음 
                        .append( "<div>" + item.value + "</div>" )	//여기에다가 원하는 모양의 HTML을 만들면 UI가 원하는 모양으로 변함.
                        .appendTo( ul );	//웹 상으로 보이는 건 정상적인 "김치 볶음밥" 인데 내부에서는 ㄱㅊㅂㅇㅂ,김치 볶음밥 에서 검색을 함.
                    };
                }
            });
            */
            
        });

        

    </script>
</head>

<body>
<div id="fullwrap">
	<jsp:include page="WEB-INF/views/include/header.jsp"></jsp:include>
	
	<div id="bodywrap">
	
	
	<section class="hero-section">
        <div class="hero-items owl-carousel">
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide1.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide2.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide3.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide4.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide5.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide6.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide7.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide8.jpg">
               
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/slide/main_slide9.jpg">
               
            </div>
        </div>
    </section>
	<div id="content">
	<input type="button" onclick="fnc()" value="누르시오">
	<script>
	function fnc(){
		console.log("함수실행");
	$.ajax(
			
			{
				url:"maincontent.ajax",
				type:"get",
				dataType:"json",
				success:function(responsedata){
					console.log(responsedata);
					
				},
				error:function(xhr){
					console.log(xhr);
				}
			}
			
			);
	}
	</script>
	
	</div>
    <!-- Footer Section Begin -->
    <footer class="footer-section">
        <div class="container">
            <h3>copyright ⓒ</h3>3
        </div>
    </footer>
    <!-- bodywrap end -->
    </div>
    
    <!-- fullwrap end -->
    </div>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery.zoom.min.js"></script>
    <script src="js/jquery.dd.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
</body>

=======
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
HELLO
<a href="member.do">member</a>
</body>
>>>>>>> 8e6f78e365620625964a7e014e9cbcb9a7dfcda7
</html>