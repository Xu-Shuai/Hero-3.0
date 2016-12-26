
function mycheck()
{
	if(form1.userName.value==""){
		alert("用户名不能为空，请输入用户名！");
		form1.userName.focus();
		return;
	}
	if(form1.password.value==""){
		alert("密码不能为空，请输入密码！");
		form1.password.focus();
		return;
	}
	if(form1.validationCode.value==""){
		alert("验证码不能为空，请输入验证码！");
		form1.validationCode.focus();
		return;
	}
	if(form1.validationCode.value!=form1.validationCode1.value){
		alert("请输入正确的验证码！");
		form1.validationCode.focus();
		return;
	}
	form1.submit1();
	}
