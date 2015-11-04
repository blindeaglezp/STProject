<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta content="text/html;charset=UTF-8"/>
		<title>友情链接</title>
		<link href="<%=request.getContextPath() %>/css/student/student1.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jQuery/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/student/left.js"></script>
	</head>
  
	<body onload="javascript:setItemBg(5);">
	
		<!-- start friend -->
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
	            <div class="friend_main_right">
	            	<div class="friend_main_right_content">
		            	<ul>
		            		<c:if test="${empty friendLinks }">
		            			<span>暂无相关信息</span>
		            		</c:if>
		            		<c:forEach items="${friendLinks }" var="friendLink">
		            				<li><a href="${friendLink.url }" target="_black">
		            					<img src="${friendLink.imgPath }" width="108" height="56" alt="${friendLink.name }"/>
		            				</a></li>
		            		</c:forEach>
		            	</ul>
	            	</div>
	            </div>
	        </div>
   		</div>
   		<!-- friend end -->
   		
	</body>
</html>
