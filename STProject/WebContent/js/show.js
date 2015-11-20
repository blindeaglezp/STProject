$(".city_item").click(function() {
    var $county = $(this).children(".county");
    var $city_img = $(this).children(".li_img").children("img");
    if ($county.is(":visible")) {
        $county.slideUp(600);
        $city_img.css("margin-top", "7px");
    } else {
        $county.slideDown(600);
        $city_img.css("margin-top", "-50px");
    }
});

//点击添加县显示功能
$(".addCounty").click(function() {
	var cityId = $(this).parent("li").val();
	var cityName = $(this).parent("li").children(".cityName").html();
	var $content = $("#addCountyForm .content");
	$content.find(".cityName").val(cityName);
	$content.find(".cityId").val(cityId);
	$content.find(".countyName").val("");
	$("#gray").show();
	$("#addCountyForm").show();
	setCenter();
});

//添加县
$(".btn_addCounty").click(function() {
	var $content = $("#addCountyForm .content");
	var cityId = $content.find(".cityId").val();
	var countyName = $content.find(".countyName").val();
	var data = {"cityId":cityId, "countyName":countyName};
	$.ajax({
		type:"post",
		url:"/STProject/servlet/DoServlet?type=addCounty",
		dataType:"json",
		data:data,
		success:function(data){
			alert(data.message);
			$(".city_item[value=" + cityId + "]").children(".county").append("<li>" + countyName +"</li>");
		}
	});
	$("#gray").hide();
	$("#addCountyForm").hide();
});

// 根据市id查询项目
function queryProjectByCityId() {
	$(".selCity option").each(function() {
		if (this.selected) {
			var cityId = $(this).val();
			var data = {"cityId":cityId};
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/STProject/servlet/DoServlet?type=queryProjectByCityId",
				data : data,
				success : function(data) {
					alert(data);
					$(data).each(function() {
						$(".content table").append("<tr><td>1</td><td></td><td></td>" +
                        "<td></td><td></td><td></td><td></td><td></td>" +
                        "<td></td><td></td><td></td><td></td><td></td></tr>");
					});
				}
			});
		}
	});
}

//点击关闭按钮 关闭功能
$("a.close").click(function() {
	$("#gray").hide();
	$("#addCountyForm").hide();
});

//当动态改变浏览器窗口时，也要水平居中
$(window).resize(function() {
	setCenter();
});

function setCenter() {
	var _top = ($(window).height() - $("#addCountyForm").height()) / 2;
	var _left = ($(window).width() - $("#addCountyForm").width()) / 2;

	//改变值
	$("#addCountyForm").css({top:_top,left:_left});
}

//拖动效果
$(document).ready(function() {
//$(function() {
	$("#addCountyForm").draggable();
});