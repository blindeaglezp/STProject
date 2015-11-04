package com.zp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zp.model.Choice;
import com.zp.model.ChoiceQuestion;
import com.zp.model.Connect;
import com.zp.model.Course;
import com.zp.model.FillBlanksQuestion;
import com.zp.model.FriendLink;
import com.zp.model.JudgeQuestion;
import com.zp.model.Score;
import com.zp.model.Student;
import com.zp.model.TestPaper;
import com.zp.service.impl.ConnectServiceImpl;
import com.zp.service.impl.CourseServiceImpl;
import com.zp.service.impl.FriendLinkServiceImpl;
import com.zp.service.impl.ScoreServiceImpl;
import com.zp.service.impl.TestPaperServiceImpl;
import com.zp.util.TestPaperData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 学生界面处理
 * 
 * @author blindeagle
 * @version 1.0
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JSONArray resultJSONArr = null; // JSON数组
	private JSONObject resultJSONObj = null; // JSON对象
	private Choice choiceObj = null; // 选项对象
	private ChoiceQuestion choiceQuestion = null; // 选择题对象
	private JudgeQuestion judgeQuestion = null; // 判断题对象
	private FillBlanksQuestion fillBlanksQuestion = null; // 填空题对象
	private TestPaper testPaper = null; // 试卷对象
	private List<FriendLink> friendLinks = null; // 友情链接信息集合
	private List<Course> courses = null; // 课程集合
	private List<Object> questionObj = null; // 存放当前试题信息的集合
	private List<Score> scores = null; // 成绩集合
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		
		if ("stu_info".equals(type)) { // 个人信息
			request.getRequestDispatcher("/WEB-INF/jsp/student/information.jsp").forward(request, response);
		} else if ("stu_exam1".equals(type)) { // 到exam1界面
			request.getRequestDispatcher("/WEB-INF/jsp/student/exam1.jsp").forward(request, response);
		} else if ("stu_exam2".equals(type)) { // 到exam2界面
			toStuExam2(request, response);
		} else if ("stu_exam3".equals(type)) { // 到exam3界面
			toStuExam3(request, response);
		} else if ("stu_exam4".equals(type)) { // 到exam4界面
			request.getRequestDispatcher("/WEB-INF/jsp/student/exam4.jsp").forward(request, response);
		} else if ("stu_grade".equals(type)) { // 成绩查询
			toStuGrade(request, response);
		} else if ("stu_friend".equals(type)) { // 友情链接
			toStuFriend(request, response);
		} else if ("stu_connect".equals(type)) { // 联系我们
			toStuConnect(request, response);
		} else if ("query_testpaper_by_courseid".equals(type)) { // 根据课程号查询试卷信息
			queryTestpaperByCourseId(request, response);
		} else if ("query_testpaper_by_testpaperid".equals(type)) { // 根据试卷号获取试卷信息
			queryTestpaperByTestpaperId(request, response);
		} else if ("query_question_by_questionindex".equals(type)) { // 根据试题索引获取试卷信息
			queryQuestionByQuestionIndex(request, response);
		} else if ("stu_index".equals(type)) { // 到index页面
			request.getRequestDispatcher("/WEB-INF/jsp/student/index.jsp").forward(request, response);
		} else if ("query_score_by_studentid".equals(type)) { // 根据学号查询成绩
			queryScore(request, response, type);
		} else if ("submit_testpaper".equals(type)) { // 提交试卷
			submitTestpaper(request, response);
		} else if ("server_error".equals(type)) { // 服务器错误
			request.getRequestDispatcher("/WEB-INF/jsp/error/server_error.jsp").forward(request, response);
		} else if ("query_scores_by_studentid_and_courseid".equals(type)) { // 根据学号和课程号查询成绩
			queryScore(request, response, type);
		} else if("log_out".equals(type)) {
			logOut(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 将试题选项拆分并将试题选项封装到为Choice对象
	 * @author blindeagle
	 * @param choiceQuestion 试题对象
	 * @return Choice 封装完成的Choice对象
	 */
	private Choice packageChoice(ChoiceQuestion choiceQuestion) {
		String[] choice = choiceQuestion.getChoice().split("---");
		choiceObj = new Choice();
		choiceObj.setA(choice[0]);
		choiceObj.setB(choice[1]);
		choiceObj.setC(choice[2]);
		choiceObj.setD(choice[3]);
		return choiceObj;
	}
	
	/**
	 * 跳转到exam2界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toStuExam2(HttpServletRequest request, HttpServletResponse response) {
		String gradeId = request.getParameter("grade_id");
		courses = new CourseServiceImpl().queryCourseByGradeId(gradeId);
		request.setAttribute("courses", courses);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/student/exam2.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到exam3界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toStuExam3(HttpServletRequest request, HttpServletResponse response) {
		testPaper = (TestPaper) request.getSession().getAttribute("testpaper");
		// 检查试卷是否已经提交过，若已经提交，则跳转到错误页面
		String studentId = ((Student) request.getSession().getAttribute("user")).getId();
		String testPaperId = testPaper.getId();
		boolean flag = new ScoreServiceImpl().checkScoreIsSubmit(studentId, testPaperId);
		if (flag) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/error/double_test_error.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 查询并将查询结果添加到试题集合
		int questionCount = new TestPaperServiceImpl().findAndPackageMap(testPaper);
		Object question = TestPaperData.questions.get(1);
		if (question instanceof ChoiceQuestion) {
			choiceQuestion = (ChoiceQuestion) question;
			choiceObj = packageChoice(choiceQuestion);
			request.setAttribute("choiceQuestion", choiceQuestion);
			request.setAttribute("questionType", "choiceQuestion");
			request.setAttribute("choice", choiceObj);
			request.setAttribute("questionCount", questionCount);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/student/exam3.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (question instanceof JudgeQuestion) {
			judgeQuestion = (JudgeQuestion) question;
			request.setAttribute("judgeQuestion", judgeQuestion);
			request.setAttribute("questionType", "judgeQuestion");
			request.setAttribute("questionCount", questionCount);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/student/exam3.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (question instanceof FillBlanksQuestion) {
			fillBlanksQuestion = (FillBlanksQuestion) question;
			request.setAttribute("fillBlanksQuestion", fillBlanksQuestion);
			request.setAttribute("questionType", "fillBlanksQuestion");
			request.setAttribute("fillblankscount", fillBlanksQuestion.getBlanks().split("---").length);
			request.setAttribute("questionCount", questionCount);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/student/exam3.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 跳转到friend界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toStuFriend(HttpServletRequest request, HttpServletResponse response) {
		friendLinks = new FriendLinkServiceImpl().queryAllFriendLink();
		request.setAttribute("friendLinks", friendLinks);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/student/friend.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到connect界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toStuConnect(HttpServletRequest request, HttpServletResponse response) {
		List<Connect> connects = new ConnectServiceImpl().queryConnect();
		request.setAttribute("connects", connects);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/student/connect.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据课程号查询试卷信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryTestpaperByCourseId(HttpServletRequest request, HttpServletResponse response) {
		String courseId = request.getParameter("courseid");
		List<TestPaper> testPapers = new TestPaperServiceImpl().queryTestPaperByCourseId(courseId);
		resultJSONArr = JSONArray.fromObject(testPapers);
		try {
			response.getWriter().print(resultJSONArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据试卷号获取试卷信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryTestpaperByTestpaperId(HttpServletRequest request, HttpServletResponse response) {
		String testPaperId = request.getParameter("testpaperid");
		testPaper = new TestPaperServiceImpl().queryTestPaperByTestPaperId(testPaperId);
		request.getSession().setAttribute("testpaper", testPaper);
		resultJSONObj = JSONObject.fromObject(testPaper);
		try {
			response.getWriter().print(resultJSONObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据试题索引获取试卷信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryQuestionByQuestionIndex(HttpServletRequest request, HttpServletResponse response) {
		questionObj = new ArrayList<Object>();
		int index = Integer.parseInt(request.getParameter("index")); //要获取试题的索引值
		// 将当前题号和答案存入试题结果集合中
		int currentIndex = Integer.parseInt(request.getParameter("currentIndex"));
		String answer = request.getParameter("answer");
		if (answer != null && answer.trim() != "") {
			TestPaperData.answers.put(currentIndex, answer);
		}
		
		// 获取要展示的题目
		Object question = TestPaperData.questions.get(index);
		if (question instanceof ChoiceQuestion) {
			choiceQuestion = (ChoiceQuestion) question;
			choiceObj = packageChoice(choiceQuestion);
			String questionType = "{'questiontype':'choiceQuestion'}";
			questionObj.add(questionType);
			questionObj.add(choiceQuestion);
			questionObj.add(choiceObj);
		} else if (question instanceof JudgeQuestion) {
			judgeQuestion = (JudgeQuestion) question;
			String questionType = "{'questiontype':'judgeQuestion'}";
			questionObj.add(questionType);
			questionObj.add(judgeQuestion);
		} else if (question instanceof FillBlanksQuestion) {
			fillBlanksQuestion = (FillBlanksQuestion) question;
			String questionType = "{'questiontype':'fillBlanksQuestion'}";
			String fillblanksCount = "{'fillblankscount':'" + fillBlanksQuestion.getBlanks().split("---").length + "'}";
			questionObj.add(questionType);
			questionObj.add(fillBlanksQuestion);
			questionObj.add(fillblanksCount);
		}
		resultJSONArr = JSONArray.fromObject(questionObj);
		try {
			response.getWriter().print(resultJSONArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 提交试卷
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void submitTestpaper(HttpServletRequest request, HttpServletResponse response) {
		
		// 检查试卷是否已经提交过，若已经提交，则跳转到作物页面
		testPaper = (TestPaper) request.getSession().getAttribute("testpaper");
		String studentId = ((Student) request.getSession().getAttribute("user")).getId();
		String testPaperId = testPaper.getId();
		boolean flag = new ScoreServiceImpl().checkScoreIsSubmit(studentId, testPaperId);
		if (flag) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/error/double_test_error.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 将当前题号和答案存入试题结果集合中
		int currentIndex = Integer.parseInt(request.getParameter("currentIndex"));
		String answer = request.getParameter("answer");
		if (answer != null && answer.trim() != "") {
			TestPaperData.answers.put(currentIndex, answer);
		}
		
		// 计算最终分数
		int score = 0;
		Map<Integer, Object> questions = TestPaperData.questions;
		Map<Integer, Object> answers = TestPaperData.answers;
		for (Map.Entry<Integer, Object> entry : questions.entrySet()) {
			Object question = entry.getValue();
			if (question instanceof ChoiceQuestion) {
				choiceQuestion = (ChoiceQuestion) question;
				if (choiceQuestion.getResult().equals(answers.get(entry.getKey()))) {
					score += 10;
				}
			} else if (question instanceof JudgeQuestion) {
				judgeQuestion = (JudgeQuestion) question;
				if (judgeQuestion.getTrueOrFalse().equals(answers.get(entry.getKey()))) {
					score += 10;
				}
			} else if (question instanceof FillBlanksQuestion) {
				fillBlanksQuestion = (FillBlanksQuestion) question;
				String[] blanks = fillBlanksQuestion.getBlanks().split("---");
				String[] results = ((String) (answers.get(entry.getKey()))).split(",");
				for (int i = 0; i < results.length; i++) {
					if (blanks[i].equals(results[i])) {
						score += 2;
					}
				}
			}
		}
		
		// 将答案存入数据库
		int result = new ScoreServiceImpl().insertScore(studentId, testPaperId, score);
		String param = "";
		if (result != 0) {
			param = "{'data':'success'}";
		} else {
			param = "{'data':'fail'}";
		}
		try {
			response.getWriter().print(JSONObject.fromObject(param));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到grade页面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toStuGrade(HttpServletRequest request, HttpServletResponse response) {
		try {
			Student student = (Student) request.getSession().getAttribute("user");
			courses = new CourseServiceImpl().queryCourseByGradeId(student.getGradeId());
			request.setAttribute("courses", courses);
			request.getRequestDispatcher("/WEB-INF/jsp/student/grade.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据不同条件查询分数
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param type 请求类型
	 * @return void
	 */
	private void queryScore(HttpServletRequest request, HttpServletResponse response, String type) {
		Student student = (Student) request.getSession().getAttribute("user");
		if (student != null) {
			if ("query_score_by_studentid".equals(type)) {
				scores = new ScoreServiceImpl().queryScoreByStudentId(student.getId());
			} else if ("query_scores_by_studentid_and_courseid".equals(type)) {
				String courseId = request.getParameter("courseid");
				scores = new ScoreServiceImpl().queryScoreByStudentIdAndCourseId(student.getId(), courseId);
			}
			List<Object[]> scoresInfo = new ArrayList<Object[]>();
			Object[] scoreInfo = null;
			for (Score score : scores) {
				scoreInfo = new Object[3];
				testPaper = new TestPaperServiceImpl().queryTestPaperByTestPaperId(score.getTestpaperId());
				String testPaperName = testPaper.getName();
				String courseName = new CourseServiceImpl().queryCourseByCourseId(testPaper.getCourseId()).getName();
				scoreInfo[0] = testPaperName;
				scoreInfo[1] = courseName;
				scoreInfo[2] = score.getValue();
				scoresInfo.add(scoreInfo);
			}
			scores = null;
			resultJSONArr = JSONArray.fromObject(scoresInfo);
			try {
				response.getWriter().print(resultJSONArr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 退出登录
	 * @author blindeagle 
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void logOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("/OnLineTest/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}








