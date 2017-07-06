<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>insertForm</title> 
</head> 
<body>
<center>
<script type="text/javascript">
	//저장
	function goInsert(){
		var fm= document.fm_insert;
		fm.action="board_insert.jsp";
		fm.submit();
	}
	
	//취소
	function goCancel(){
		window.history.go(-1);
	}
</script>

<form name="fm_insert" action="#" method="post">
 
<h2>신규목록추가입니다.</h2>
<!-- 게시물 입력 폼 테이블 -->
<table width="850" border="1">
	<tr>
		<td width="100">BOARD_ID</td>
		<td width="325" align="left"><input type="text" name="BOARD_ID" size="30" disabled="disabled"></td>
		<td width="100">BOARD_TITLE</td>
		<td width="325" align="left"><input type="text" name="BOARD_TITLE" size="30"></td>
	</tr>
	<tr>
		<td width="100">BOARD_WRITER</td>
		<td width="325" align="left"><input type="text" name="BOARD_WRITER" size="30"></td>
		<td width="100">BOARD_DATE</td>
		<td width="325" align="left"><input type="text" name="BOARD_DATE" size="30" disabled="disabled"></td>
	</tr>
	<tr>
		<td width="100">BOARD_CONTENT</td>
		<td width="325" align="left" colspan="3">
			<textarea rows="20" cols="100" name="BOARD_CONTENT"></textarea>
		</td>
		
	</tr>
</table>

	
<!-- 버튼 처리 테이블 -->
<table width="850" border="0">
	<tr>
		<td>
			<input type="button" value="저장" onclick="goInsert()"><!-- board_insert.jsp페이지로 -->
			<input type="button" value="최소" onclick="goCancel()">	<!-- 이전페이지로 -->
		</td>
	</tr>
</table>
</form>
</center> 
	 
</body> 
</html>
