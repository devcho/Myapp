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
	�̸� : <input type="text" id="Uname" name="Uname" /><br/>
	����� ���̵� : <input type="text" id="Uid" name="Uid" /><br/>
	</form>
	<input type="button" class="submit" value="����" />
</body>
<script type="text/javascript">
<!--
	$(".submit").click(function(){
		if($("#Uname").val() == ""){
			alert('�̸��� �Է��ϼ���'); 
		}else if($("#Uid").val() == ""){
			alert('����ھ��̵� �Է��ϼ���'); 
		}else{
			alert("����"); 
		}  
	});
//-->
</script>
</html>