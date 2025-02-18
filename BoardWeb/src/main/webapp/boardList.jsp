<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html에서의 주석. -->
	<% // <% % => 자바코드를 쓸수 있음.
	String msg = "Hello";
	System.out.println(msg);
	
	// boardList.do -> request -> boardList.jsp
	String result = (String) request.getAttribute("msg"); // getAttribute-> object타입이여서 캐스팅 (String)을 해줘야 한다.
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	
	<p>msg의 값은 <%=result %></p>
	<h3>게시글 목록</h3>
	<table border="2">
	<tbody>
	<%
	for (BoardVO board : list) {
	%>
		<tr>
			<td><%=board.getBoardNo() %></td>
			<td><%=board.getTitle() %></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getWriteDate() %></td>
			<td><%=board.getViewCnt() %></td>		
		</tr>
	<%
	} // for 종료.
	%>
	 </tbody>
	</table>
</body>
</html>