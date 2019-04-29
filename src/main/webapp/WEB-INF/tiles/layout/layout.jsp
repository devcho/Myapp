<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트</title>
</head>

<body>

<div style="clear:both;width:100%;height:20px;">
	 <tiles:insertAttribute name="header" />
</div>

<div style="float:right;position:relative;width:100%;">
	 <tiles:insertAttribute name="content" />
</div>

<div style="clear:both;width:100%;">
 <tiles:insertAttribute name="footer" />
</div>

</body>

</html>
