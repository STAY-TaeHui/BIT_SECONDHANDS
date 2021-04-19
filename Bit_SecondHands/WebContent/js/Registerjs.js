$(function() {
	$('#submitBtn').click(function() {
		let email = $('#email').val();
		let password = $('#password').val();
		let passwordC = $('#passwordC').val();
		let name = $('#name').val();
		let shopName = $('#shopName').val();
		let phone = $('#phone').val();

		console.log(email);
		console.log(password);
		console.log(passwordC);
		console.log(name);
		console.log(shopName);
		console.log(phone);

		let checking = true;

			//이메일 체크
			if (email == "") {
				alert('이메일을 입력하세요');
				checking = false;
				return ;
			}

			//비밀번호 체크 
			let num = password.search(/[0-9]/g);
			let eng = password.search(/[0-9]/ig);
			let spe = password.search(/[`~!@#$%^&*|\\\'\";:\/?]/gi);

			if (password.length < 8 || password.length > 13) {
				alert("비밀번호는 8-20자리 이내로 입력하세요");
				checking = false;
				return ;
				
			} else if (password.search(/\s/) != -1) {
				alert("비밀번호는 공백을 입력할 수 없습니다");
				checking = false;
				return ;
				
			} else if (num < 0 || eng < 0 || spe < 0) {
				alert("영문, 숫자, 특수문자를 포함하여 입력하세요");
				checking = false;
				return ;
			}
			
			if (password == '') {
				alert('비밀번호를 입력하세요');
				checking = false;
				return ;
			}


			//비밀번호 일치 체크
			if (!(password == passwordC)) {
				alert("비밀번호가 일치하지 않습니다");
				console.log(password);
				console.log(passwordC);
				checking = false;
				return ;
			}
			
			if(passwordC == "") {
				alert('비밀번호 확인란을 입력하세요');
				checking = false;
				return ;
			}

			//이름 체크
			if (name == '') {
				alert('이름을 입력하세요');
				checking = false;
				return ;
			}

			//상점 이름 체크
			if (shopName == '') {
				alert('이름을 입력하세요');
				checking = false;
				return ;
			}

			//전화번호 체크
			phoneC = phone.substring(0,3)+'-'+phone.substring(3,7)+'-'+phone.substring(7,11);
			let regExp = /^\d{3}-\d{3,4}-\d{4}$/;
			if (regExp.test(phoneC)) {
				
			} else {
				alert("핸드폰번호가 올바르지 않습니다(ex. 010-0000-0000)");
				checking = false;
				return ;
			}
			
			if(checking){
				document.getElementById('form').submit();
			}
		});
});