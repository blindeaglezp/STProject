function logOut() {
	if (confirm("确定退出吗？")) {
		window.location = "/OnLineTest/servlet/StudentServlet?type=log_out";
	}
}