<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>个人信息</title>
    <link href="<%=request.getContextPath() %>/css/student/student1.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jQuery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/student/left.js"></script>
</head>
<body onload="javascript:setItemBg(1);">

	<!-- start information -->
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
            <div class="info_main_right">
                <div class="info_main_right_content">
		            <table>
		                <tr>
		                    <td class="info_td_title">学号：</td>
		                    <td class="info_td_content">${user.id }</td>
		                </tr>
		                <tr>
		                    <td class="info_td_title">姓名：</td>
		                    <td class="info_td_content">${user.name }</td>
		                </tr>
		                <tr>
		                    <td class="info_td_title">性别：</td>
		                    <td class="info_td_content">${user.sex }</td>
		                </tr>
		                <tr>
		                    <td class="info_td_title">年龄：</td>
		                    <td class="info_td_content">${user.age }</td>
		                </tr>
		                <tr>
		                    <td class="info_td_title">电话：</td>
		                    <td class="info_td_content">${user.phone }</td>
		                </tr>
		                <tr>
		                    <td class="info_td_title">邮件：</td>
		                    <td class="info_td_content">${user.email }</td>
		                </tr>
		                <tr>
		                    <td class="info_td_title">地址：</td>
		                    <td class="info_td_content">${user.address }</td>
		                </tr>
		            </table>
        		</div>
            </div>
        </div>
    </div>
    <!-- information end -->
    
</body>
</html>