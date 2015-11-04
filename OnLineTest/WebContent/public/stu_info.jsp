<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/student/info.js"></script>
<p>姓名：${user.name}</p>
<p>学号：${user.id}</p>
<p>班级：${user.classId}</p>
<a href="javascript:void(0);" onclick="javascript:logOut();">注销</a>