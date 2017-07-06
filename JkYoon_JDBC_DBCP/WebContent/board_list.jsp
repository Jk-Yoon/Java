<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String dbcpName = "jdbc:apache:commons:dbcp:/cp";
	Connection conn = DriverManager.getConnection(dbcpName);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String query = "SELECT 					"+
			"				BOARD_ID 		"+
			"			,	BOARD_TITLE		"+
			"			,	BOARD_WRITER	"+	
			"			,	BOARD_DATE		"+
			"			,	BOARD_CONTENT 	"+
			"	 FROM FX_BOARD  ";
	
	// PreparedStatement를 가져온다.
	pstmt = conn.prepareStatement(query);
	
	//pstmt.setString(1, "0000000001");

	// SQL문을 실행한다.
	rs = pstmt.executeQuery();

	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//등록창으로 이동
	function goInsertForm(){
		var frm= document.frm;
		frm.action="board_insertForm.jsp";
		frm.submit();
	}
	
	//취소
	function goCancel(){
		window.history.go(-1);
	}
	
	//상세페이지로 이동
	function goView(board_id){
		var fm = document.frm;
		fm.BOARD_ID.value = board_id;
		fm.action = "board_view.jsp";
		fm.submit();
	}	
</script>
</head>
<body>
<center>
	<form name="frm" method="post">
		<input type="hidden" name="BOARD_ID">
	</form>	
	<h2>게시판 목록 리스트</h2>
	<!-- 버튼 처리 테이블 -->
	<table width="460" border="0">
		<tr>
			<td align="right">
				<!-- board_insertForm.jsp페이지로 이동 -->
				<input type="button" value="신규입력" onclick="goInsertForm()">	
			</td>
		</tr>
	
	</table>
		<table border="1">
			<tr>
				<td>BOARD_ID</td>
				<td>BOARD_TITLE</td>
				<td>BOARD_WRITER</td>
				<td>BOARD_CONTENT</td>
			</tr>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("BOARD_ID") %></td>
				<td>
					<a href="#" onclick="goView('<%= rs.getString("BOARD_ID") %>')">
						<%=rs.getString("BOARD_TITLE") %>
					</a>
				</td>
				<td><%=rs.getString("BOARD_WRITER") %></td>
				<td><%=rs.getString("BOARD_CONTENT") %></td>
			</tr>
			<%
			}
			 %>
		</table>
		
	
</center>
</body>
</html>