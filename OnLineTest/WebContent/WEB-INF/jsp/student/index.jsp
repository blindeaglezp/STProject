<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>学生首页</title>
    <link href="<%=request.getContextPath() %>/css/student/student1.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jQuery/jquery-2.1.4.min.js"></script>
</head>
<body>

	<!-- start index -->
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
            <div class="index_main_right">
                <div class="index_main_right_content">
                    <p>
                        	欢迎来到在线考试系统：
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- index end -->
    
</body>
</html>