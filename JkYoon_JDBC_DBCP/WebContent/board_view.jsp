<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<% request.setCharacterEncoding("UTF-8"); %> 
<%
	//board_list.jsp에서 넘긴 bo_id를 받자...
	int boardId = Integer.parseInt(request.getParameter("BOARD_ID"));
	System.out.print("boardId = " + boardId);


	String dbcpName = "jdbc:apache:commons:dbcp:cp";
	Connection conn = DriverManager.getConnection(dbcpName);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String query = "SELECT 					"+
			"				BOARD_ID 		"+
			"			,	BOARD_TITLE		"+
			"			,	BOARD_WRITER	"+	
			"			,	BOARD_DATE		"+
			"			,	BOARD_CONTENT 	"+
			"	 FROM FX_BOARD  			"+
			"	WHERE BOARD_ID = ? ";
	
	// PreparedStatement를 가져온다.
	pstmt = conn.prepareStatement(query);
	
	pstmt.setInt(1, boardId);
	
	// SQL문을 실행한다.
	rs = pstmt.executeQuery();


	// 값을 가져온다.
	rs.next();
 
	
	// rs이 null인지 체크
	if(rs == null){
		out.println("<script>"								);
		out.println(" alert('조회할 데이터가 없습니다.!!'); ");
		out.println(" window.history.go(-1); "				);
		out.println("</script>"								);
	}else{
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>게시판상세</title> 
</head> 
<body> 
<center>

<script type="text/javascript">
	 
	//삭제
	
	//목록으로..
	function goList(){
		window.history.go(-1);
	}
	

</script>

<form name="fm_view" action="#" method="post">
	<input type="hidden" name="BOARD_ID" value=""><%--  <%= rs.getString("BOARD_ID") %> --%>
</form>

<!-- 상세보기 -->
<h2>게시물 상세보기</h2>
<table width ="850" border="1">
	<tr>
		<td width="100">BOARD_ID</td>
		<td width="325" align="left"><input type="text" name="BOARD_ID" size="30" disabled="disabled" value="<%= rs.getString("BOARD_ID") %>"></td>
		<td width="100">BOARD_TITLE</td>
		<td width="325" align="left"><input type="text" name="BOARD_TITLE" size="30" value="<%= rs.getString("BOARD_TITLE") %>"></td>
	</tr>
	<tr>
		<td width="100">BOARD_WRITER</td>
		<td width="325" align="left"><input type="text" name="BOARD_WRITER" size="30" value="<%= rs.getString("BOARD_WRITER") %>" ></td>
		<td width="100">BOARD_DATE</td>
		<td width="325" align="left"><input type="text" name="BOARD_DATE" size="30" disabled="disabled" value="<%= rs.getString("BOARD_DATE") %>"></td>
	</tr>
	<tr>
		<td width="100">BOARD_CONTENT</td>
		<td width="325" align="left" colspan="3">
			<textarea rows="20" cols="100" name="BOARD_CONTENT" >
				<%= rs.getString("BOARD_CONTENT") %>
			</textarea>
		</td>
		
	</tr>
</table>

<!-- 버튼 처리 테이블 -->
<table width = "850" border = "0">
	<tr>
		<td>
			<input type="button" value="수정" onclick="goUpdate()">
			<input type="button" value="삭제">
			<input type="button" value="목록으로" onclick="goList()">
		</td>
	</tr>
</table>
<%
	}
%>

</center>
</body> 
</html>
