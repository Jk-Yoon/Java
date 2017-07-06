<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>18day/신규입력 및 답변처리</title>
</head>
<body>
<%
	String boardTitle = request.getParameter("BOARD_TITLE");
	String boardWriter = request.getParameter("BOARD_WRITER");
	String boardContent = request.getParameter("BOARD_CONTENT");


	String dbcpName = "jdbc:apache:commons:dbcp:cp";
	Connection conn = DriverManager.getConnection(dbcpName);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	 
	
	int resultInt = 0;
	 
	String query = "INSERT INTO FX_BOARD "
			+ "("
			+ "	 BOARD_ID"
			+ ", BOARD_TITLE"
			+ ", BOARD_WRITER"
			+ ", BOARD_DATE"
			+ ", BOARD_CONTENT"
			+ ") "
			+ "VALUES "
			+ "((SELECT NVL(MAX(BOARD_ID),0)+1 FROM FX_BOARD)"
			+ ", ? "
			+ ", ? "
			+ ", SYSDATE"
			+ ", ? )";
	
	System.out.println(query);
	
	// connection객체의 PreparedStatement를 가져온다.
	pstmt = conn.prepareStatement(query);
	
	//파라미터세팅
	pstmt.setString(1,boardTitle);			 
	pstmt.setString(2,boardWriter);
	pstmt.setString(3,boardContent);
	
	// 쿼리를 실행하여 결과값을 받는다.
	resultInt = pstmt.executeUpdate();
	
	System.out.println("resultInt = "+resultInt);
	
	
	
	//결과값이 0보다 크면 정상적으로 입력
	//결과값이 0보다 작으면 비정상적 입력 실패..
	if (resultInt > 0) {
%>
	<script type="text/javascript">
		alert("정상적으로 이루어 졌습니다.");
		location.href = "board_list.jsp";			
	</script>
<%
} else {
%>
	<script type="text/javascript">
		alert("입력하신 데이터를 확인해 주세요!");
		window.history.go(-1);		
	</script>
<%
}
%>
</body>
</html>
