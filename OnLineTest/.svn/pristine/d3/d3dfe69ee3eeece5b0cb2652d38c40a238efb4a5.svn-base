//通过选择课程来获取试卷信息
function changeCourse() {
	$(".course option").each(function() {
		if (this.selected) {
			var data = this.value;
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/OnLineTest/servlet/StudentServlet?type=query_testpaper_by_courseid",
				data : {"courseid" : data},
				success : function(data) {
					$(data).each(function() {
						$(".testpaper").append("<option value="+ this.id+ ">"+ this.name+ "</option>");
					});
				}
			});
		}
	});
}

//通过选择课程来获取试卷信息
function changeTestPaper() {
	$(".exam2_confirm_testpaper a").show();
}

//通过选择试卷来获取被选择试卷的试卷信息
$(".exam2_confirm_testpaper a").click(function() {
	$(".exam2_start_test a").show();
	$(".testpaper option").each(function() {
		if (this.selected) {
			var data = this.value;
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/OnLineTest/servlet/StudentServlet?type=query_testpaper_by_testpaperid",
				data : {"testpaperid" : data},
				success : function(data) {
					$(data).each(function() {
						var li = $(".exam2_testpaper_info ul li");
						li.eq(0).append(this.name);
						li.eq(1).append(this.score);
						li.eq(2).append(this.testDate);
					});
				}
			});
		}
	});
});

//通过下标获取对应试题内容
function getQuestionAjax(index, data) {
	//$("#answer_sheet .content ul li").eq(index-1).css({"background":"#111", "color":"#EEE"}).siblings().css({"background":"#EEE", "color":"#111"});
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/OnLineTest/servlet/StudentServlet?type=query_question_by_questionindex",
		data : data,
		success : function(data) {
			if (data[0].questiontype != null) {
				$("#exam_content .questionType").val(data[0].questiontype);
			}
			if (data[0].questiontype == "choiceQuestion") {
				$("#exam_content .content_choice_question").css({"display":"block"});
				$("#exam_content .answer_choice_question").css({"display":"block"});
				$("#exam_content .content_judge_question").css({"display":"none"});
				$("#exam_content .answer_judge_question").css({"display":"none"});
				$("#exam_content .content_fillblanks_question").css({"display":"none"});
				$("#exam_content .answer_fillblanks_question").css({"display":"none"});
				$("#exam_content .content_choice_question").children("p").html("<span>第" + index + "题：</span>" + data[1].description).attr("index", index + "");
				$("#exam_content .content_choice_question").children(".choiceQuestionId").attr("value", data[1].id)
				var ps = $("#exam_content .content_choice_question .answer_options p")
				ps.eq(0).html("A. " + data[2].a);
				ps.eq(1).html("B. " + data[2].b);
				ps.eq(2).html("C. " + data[2].c);
				ps.eq(3).html("D. " + data[2].d);
				$("#exam_content .answer_choice_question .content .choice_answer").removeAttr("checked");
			} else if (data[0].questiontype == "judgeQuestion") {
				$("#exam_content .content_choice_question").css({"display":"none"});
				$("#exam_content .answer_choice_question").css({"display":"none"});
				$("#exam_content .content_judge_question").css({"display":"block"});
				$("#exam_content .answer_judge_question").css({"display":"block"});
				$("#exam_content .content_fillblanks_question").css({"display":"none"});
				$("#exam_content .answer_fillblanks_question").css({"display":"none"});
				$("#exam_content .content_judge_question").children("p").html("<span>第" + index + "题：</span>").attr("index", index + "");
				$("#exam_content .content_judge_question").children(".judgeQuestionId").attr("value", data[1].id)
				var ps = $("#exam_content .content_judge_question .answer_description p")
				ps.eq(0).html(data[1].description);
				$("#exam_content .answer_judge_question .content .answer").removeAttr("checked");
			} else if (data[0].questiontype == "fillBlanksQuestion") {
				$("#exam_content .content_choice_question").css({"display":"none"});
				$("#exam_content .answer_choice_question").css({"display":"none"});
				$("#exam_content .content_judge_question").css({"display":"none"});
				$("#exam_content .answer_judge_question").css({"display":"none"});
				$("#exam_content .content_fillblanks_question").css({"display":"block"});
				$("#exam_content .answer_fillblanks_question").css({"display":"block"});
				$("#exam_content .content_fillblanks_question").children("p").html("<span>第" + index + "题：</span>").attr("index", index + "");
				$("#exam_content .content_fillblanks_question").children(".fillBlanksQuestionId").attr("value", data[1].id)
				var ps = $("#exam_content .content_fillblanks_question .answer_description p")
				ps.eq(0).html(data[1].description);
				var cs = $("#exam_content .answer_fillblanks_question .content");
				for (var i = 0; i < data[2].fillblankscount; i++) {
					cs.append("<div class='content_option' contenteditable='true'></div>");
				}
			}
		}
	});
}

//点击下一题，获取下一题内容
function nextQuestion() {
	var questionType = $("#exam_content .questionType").val();
	var questionId = getQuestionId(questionType);
	var currentIndex = getQuestionIndex(questionType);
	var answer = getAnswer(questionType);
	var index = currentIndex + 1;
	var data = {"currentIndex":currentIndex, "index":index, "questionId":questionId, "questionType":questionType, "answer":answer};
	getQuestionAjax(index, data);
	if (answer.trim() != "") {
		$("#answer_sheet .content ul li").eq(currentIndex-1).css({"background":"#93C8FE","color":"#111"});
	}
}

//点击上一题，获取上一题内容
function preQuestion() {
	var questionId = getQuestionId(questionType);
	var questionType = $("#exam_content .questionType").val();
	var currentIndex = getQuestionIndex(questionType);
	var answer = getAnswer(questionType);
	var index = currentIndex - 1;
	var data = {"currentIndex":currentIndex, "index":index, "questionId":questionId, "questionType":questionType, "answer":answer};
	getQuestionAjax(index, data);
	if (answer.trim() != "") {
		$("#answer_sheet .content ul li").eq(currentIndex-1).css({"background":"#93C8FE","color":"#111"});
	}
}

//点击第一题，获取第一题内容
function firstQuestion() {
	var questionId = getQuestionId(questionType);
	var questionType = $("#exam_content .questionType").val();
	var currentIndex = getQuestionIndex(questionType);
	var answer = getAnswer(questionType);
	var index = 1;
	var data = {"currentIndex":currentIndex, "index":index, "questionId":questionId, "questionType":questionType, "answer":answer};
	getQuestionAjax(index, data);
	if (answer.trim() != "") {
		$("#answer_sheet .content ul li").eq(currentIndex-1).css({"background":"#93C8FE","color":"#111"});
	}
}

//点击最后一题，获取最后一题内容
function lastQuestion() {
	var index = $(".sessionvalue").val();
	var questionId = getQuestionId(questionType);
	var questionType = $("#exam_content .questionType").val();
	var currentIndex = getQuestionIndex(questionType);
	var answer = getAnswer(questionType);
	var data = {"currentIndex":currentIndex, "index":index, "questionId":questionId, "questionType":questionType, "answer":answer};
	getQuestionAjax(index, data);
	if (answer.trim() != "") {
		$("#answer_sheet .content ul li").eq(currentIndex-1).css({"background":"#93C8FE","color":"#111"});
	}
}

//点击li标签，获取对应试题内容
$(document).ready(function() {
    var ul = $("#answer_sheet .content ul");
    $(document).on("click", "li.question_index", function() {
        var index = parseInt($(this).val());
        var questionId = getQuestionId(questionType);
        var questionType = $("#exam_content .questionType").val();
        var currentIndex = getQuestionIndex(questionType);
    	var answer = getAnswer(questionType);
        var data = {"currentIndex":currentIndex, "index":index, "questionId":questionId, "questionType":questionType, "answer":answer};
        getQuestionAjax(index, data);
        if (answer.trim() != "") {
    		$("#answer_sheet .content ul li").eq(currentIndex-1).css({"background":"#93C8FE","color":"#111"});
    	}
    });
});

// 首次加载，设置显示的元素并且设置答题卡上的元素
function getQuestionCount() {
	var count = $("#exam_content .sessionvalue").val();
	var questionType = $("#exam_content .questionType").val();
	
	// 设置显示元素
	if ("choiceQuestion" == questionType) {
		$("#exam_content .content_choice_question").css({"display":"block"});
		$("#exam_content .answer_choice_question").css({"display":"block"});
		$("#exam_content .content_judge_question").css({"display":"none"});
		$("#exam_content .answer_judge_question").css({"display":"none"});
		$("#exam_content .content_fillblanks_question").css({"display":"none"});
		$("#exam_content .answer_fillblanks_question").css({"display":"none"});
	} else if ("judgeQuestion" == questionType) {
		$("#exam_content .content_choice_question").css({"display":"none"});
		$("#exam_content .answer_choice_question").css({"display":"none"});
		$("#exam_content .content_judge_question").css({"display":"block"});
		$("#exam_content .answer_judge_question").css({"display":"block"});
		$("#exam_content .content_fillblanks_question").css({"display":"none"});
		$("#exam_content .answer_fillblanks_question").css({"display":"none"});
	} else if ("fillBlanksQuestion" == questionType) {
		$("#exam_content .content_choice_question").css({"display":"none"});
		$("#exam_content .answer_choice_question").css({"display":"none"});
		$("#exam_content .content_judge_question").css({"display":"none"});
		$("#exam_content .answer_judge_question").css({"display":"none"});
		$("#exam_content .content_fillblanks_question").css({"display":"block"});
		$("#exam_content .answer_fillblanks_question").css({"display":"block"});
	}
	
	// 设置答题卡上的元素
	var answer_sheet_content = $("#answer_sheet .content ul");
	for (var i = 0; i < count; i++) {
		answer_sheet_content.append("<li class='question_index' value='" + (i + 1) + "'>" + (i + 1) + "</li>");
	}
	
}

$(document).ready(function() {
	$("#answer_sheet").draggable();
});

// 提交试卷
function submitTestPaper() {
	if (confirm("确定提交吗？")) {
		var questionType = $("#exam_content .questionType").val();
		var questionId = getQuestionId(questionType);
		var answer = getAnswer(questionType);
		var currentIndex = getQuestionIndex(questionType);
		var data = {"currentIndex":currentIndex, "answer":answer};
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "/OnLineTest/servlet/StudentServlet?type=submit_testpaper",
			data : data,
			success : function(data) {
				if ("success" == data.data) {
					window.location = "/OnLineTest/servlet/StudentServlet?type=stu_exam4";
				} else if ("fail" == data.data) {
					window.location = "/OnLineTest/servlet/StudentServlet?type=server_error";
				}
			}
		});
	}
}

function getQuestionId(questionType) {
	var questionId = "";
	if ("choiceQuestion" == questionType) {
		questionId = $("#exam_content .content_choice_question .choiceQuestionId").val();
	} else if ("judgeQuestion" == questionType) {
		questionId = $("#exam_content .content_judge_question .judgeQuestionId").val();
	} else if ("fillBlanksQuestion" == questionType) {
		questionId = $("#exam_content .content_fillblanks_question .fillBlanksQuestionId").val();
	}
	return questionId;
}

function getAnswer(questionType) {
	var answer="";
	if ("choiceQuestion" == questionType) {
		answer = $("#exam_content .answer_choice_question .content input[name='choice_answer']:checked").val();
	} else if ("judgeQuestion" == questionType) {
		answer = $("#exam_content .answer_judge_question .content input[name='answer']:checked").val();
	} else if ("fillBlanksQuestion" == questionType) {
		var content = $("#exam_content .answer_fillblanks_question .content .content_option");
		content.each(function() {
			answer += this.html() + ",";
		});
	}
	return answer;
}

function getQuestionIndex(questionType) {
	var questionIndex = 0;
	if ("choiceQuestion" == questionType) {
		questionIndex = parseInt($("#exam_content .content_choice_question p").attr("index"));
	} else if ("judgeQuestion" == questionType) {
		questionIndex = parseInt($("#exam_content .content_judge_question p").attr("index"));
	} else if ("fillBlanksQuestion" == questionType) {
		questionIndex = parseInt($("#exam_content .content_fillblanks_question p").attr("index"));
	}
	return questionIndex;
}

// 提交成功
function submitSuccess() {
	var t = setTimeout(function() {
	window.location = "/OnLineTest/servlet/StudentServlet?type=stu_index";
	}, 3000);
}










