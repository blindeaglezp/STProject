<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta content="text/html;charset=UTF-8"/>
		<title>安全中心</title>
		<link href="<%=request.getContextPath() %>/css/student/student1.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jQuery/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/student/left.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/student/changePwd.js"></script>
	</head>
  
	<body onload="changeSuccess();">
	
		<!-- start change_password_2 -->
    	<div class="container">
	    	<div class="stu_top">
				<jsp:include page="/public/stu_head.jsp"></jsp:include>
			</div>
	        <div class="stu_info">
	        	<jsp:include page="/public/stu_info.jsp"></jsp:include>
	        </div>
	        <div class="stu_main">
	            <div class="stu_main_left">
					<jsp:include page="/public/stu_left.jsp"></jsp:include>	
				</div>  
		        <div class="change_password_2_main_right">
		            <div class="change_password_2_main_right_content"> 
		              	密码修改成功，3秒后跳转到登录界面重新登录. . . 
		            </div>
		        </div>
			</div>
    	</div>
    	<!-- change_password_2 end -->
    	
	</body>
</html>
