<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
	<form id="userreg" name="userreg" method="post">
	이름 : <input type="text" id="Uname" name="Uname" /><br/>
	사용자 아이디 : <input type="text" id="Uid" name="Uid" /><br/>
	</form>
	<input type="button" class="submit" value="전송" />
</body>
<script type="text/javascript">
<!--
	$(".submit").click(function(){
		if($("#Uname").val() == ""){
			alert('이름을 입력하세요'); 
		}else if($("#Uid").val() == ""){
			alert('사용자아이디를 입력하세요'); 
		}else{
			alert("전송"); 
		}  
	});
//-->
</script>
</html>