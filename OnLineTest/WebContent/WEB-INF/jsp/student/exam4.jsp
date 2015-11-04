<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>标题</title>
		<meta name="Keywords" content="关键字,关键字">
		<meta name="description" content="">
		<link href="<%=request.getContextPath() %>/css/student/student2.css" type="text/css" rel="stylesheet">
	</head>
	<body onload="javascript:submitSuccess();">
		<div id="exam4_container">
			<div class="error_empty1"></div>
			<div class="error_empty2"></div>
			<p>试卷提交成功，3秒后跳转到首页  . . .</p> 
   		</div>
   		
   		<script type="text/javascript" src="<%=request.getContextPath()%>/js/student/exam.js"></script>
   		
	</body>
</html>