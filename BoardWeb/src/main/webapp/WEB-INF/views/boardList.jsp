<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp"></jsp:include>
<!-- html에서의 주석. -->
<%
// <% % => 자바코드를 쓸수 있음.
String msg = "Hello";
System.out.println(msg);

// boardList.do -> request -> boardList.jsp
String result = (String) request.getAttribute("msg"); // getAttribute-> object타입이여서 캐스팅 (String)을 해줘야 한다.
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>

<h3>게시글 목록</h3>
<table class="table table-striped">
	<thead>
	<tr>
		<th>게시글 번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO board : list) {
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href="board.do?bno=<%=board.getBoardNo() %>"><%=board.getTitle()%></a></td>
			<td><%=board.getContent()%></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getWriteDate()%></td>
			<td><%=board.getViewCnt()%></td>
		</tr>
		<%
		} // for 종료.
		%>
	</tbody>
</table>
<jsp:include page="includes/footer.jsp"></jsp:include>