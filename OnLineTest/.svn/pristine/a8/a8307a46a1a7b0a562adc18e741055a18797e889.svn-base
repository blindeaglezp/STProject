<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta content="text/html;charset=UTF-8"/>
		<title>联系我们</title>
		<link href="<%=request.getContextPath() %>/css/student/student1.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jQuery/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/student/left.js"></script>
	</head>
  
	<body onload="javascript:setItemBg(6);">
	
		<!-- start connect -->
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
	            <div class="connect_main_right">
	            	<div class="connetc_main_right_content">
		            	<table>
		            		<c:forEach items="${connects }" var="connect">
		            			<tr>
		            				<td class="connect_td_title"><c:out value="${connect.name }" />:</td>
		            				<td class="connect_td_content"><c:out value="${connect.value }" /></td>
		            			</tr>
		            		</c:forEach>
		            	</table>
		            </div>
	            </div>
	        </div>
   		</div>
   		<!-- connect end -->
   		
	</body>
</html>
