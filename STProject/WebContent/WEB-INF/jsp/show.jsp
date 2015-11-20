<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>展示</title>
    <meta name="Keywords" content="关键字,关键字">
    <meta name="description" content="">
    <style type="text/css">
        body{background:#FFF;font-size:16px;font-family:"微软雅黑";color:#666;}
        *{padding:0;margin:0;}
        li{list-style:none;}
        .container{width:1200px;margin:0 auto;}
        
        /* start header */
        .header{width:100%;height:100px;font-size:40px;border-bottom:1px solid red;
            line-height:100px;}
        /* header end */    
        
        /* start city */
        .city{width:180px;border-right:1px solid red;float:left;}
        .city ul li{width:80%;margin:0 auto;}
        .city ul li:hover{cursor:pointer;}
        .city ul li button.addCounty{margin-left:20px;border:none;background:#FFF;color:#3A5FCD;}
        .city ul li button.addCounty:hover{cursor:pointer;text-decoration:underline;color:#68228B;}
        .city ul li .li_img{width:16px;height:16px;overflow:hidden;float:left;}
        .city ul li .li_img img{margin-top:7px;}
        .city ul li .county{display:none;font-size:14px;}
        .city ul li .county li{text-indent:16px;}
        /* city end */
        
        /* start proManager */
        .proManager{width:1019px;float:left;}
        .proManager .condition .selCity{text-align:center;}
        .proManager .content table{margin:30px auto 0;text-align:center;border-collapse:collapse;border-style:solid;
            line-height:25px;}
        /* proManager end */
        
        /* start addCountyForm */
        #gray{width:100%;height:100%;background:rgba(0,0,0,0.5);position:absolute;top:0px;display:none;}
		#addCountyForm{width:400px;height:300px;background:#FFF;position:absolute;left:400px;top:150px;display:none;}
		#addCountyForm .title{width:400px;height:45px;background:#FF9933;color:#FFF;font-size:18px;font-family:"微软雅黑";line-height:45px;
			text-indent:35px;}
		#addCountyForm .title:hover{cursor:pointer;}
		#addCountyForm .title a{color:#DDD;font-size:24px;text-decoration:none;float:right;margin-right:10px;}
		#addCountyForm .title a:hover{color:#FFF;}
		#addCountyForm .content{width:315px;height:190px;margin:15px auto 0px;}
		#addCountyForm .content .empty_f{width:100%;height:30px;}
		#addCountyForm .content p{font-size:16px;font-family:"微软雅黑";margin-bottom:15px;}
		#addCountyForm .content p input.txt{width:260px;height:35px;border:1px solid #DDD;border-radius:3px;padding:0 5px;}
		#addCountyForm .content input.btn_addCounty{width:305px;height:35px;background:#CCC;border:none;margin-top:20px;border-radius:3px;
				cursor:pointer;}
		/* addCountyForm end */
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            项目申报与进度管理
        </div>
        <div class="city">
            <ul>
            	<c:forEach items="${citys }" var="city">
	                <li class="city_item" value="${city.id }">
	                    <span class="cityName">${city.name }</span>
	                    <button type="button" class="addCounty">添加县</button>
	                    <div class="li_img">
	                        <img src="<%=path%>/images/navicon.png" alt=""/>
	                    </div>
	                    <ul class="county">
		                    <c:forEach items="${cityCountys[city.id]}" var="county">
		                        <li>${county.name}</li>
		                    </c:forEach>
		                </ul>
	                </li>
                </c:forEach>
            </ul>
        </div>
    	<div class="proManager">
    		<div class="condition">
    			<select class="selCity" onChange="javascript:queryProjectByCityId();">
    				<option disabled selected>请选择市</option>
    				<c:forEach items="${citys }" var="city">
    					<option value="${city.id }">${city.name }</option>
    				</c:forEach>
    			</select>
    		</div>
    		<div class="content">
                <table border="1">
                    <tr>
                        <th width="30"></th>
                        <th width="70">市</th>
                        <th width="70">县</th>
                        <th width="70">项目号</th>
                        <th width="100">项目名</th>
                        <th width="100">项目文号</th>
                        <th width="100">科目</th>
                        <th width="70">级别</th>
                        <th width="70">预期目标</th>
                        <th width="70">总数</th>
                        <th width="70">支付数</th>
                        <th width="70">支付进度</th>
                        <th width="70">审核状态</th>
                    </tr>
                </table>
            </div>
    	</div>
    </div>
    
    <div id="gray"></div>
	<div id="addCountyForm">
		<div class="title">添加县<a href="javascript:void(0);" class="close">X</a></div>
		<div class="content">
			<div class="empty_f"></div>
			<p class="test"></p>
			<p>市名<input type="text" class="cityName txt" value="123" disabled/></p>
			<input type="hidden" class="cityId"/>
			<p>县名<input type="text" class="countyName txt"/></p>
			<input type="button" class="btn_addCounty" value="提交"/>
		</div>
	</div>

    <script src="<%=path%>/js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/show.js" type="text/javascript"></script>

</body>
</html>