<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글 목록</a>
                    <c:choose>
                    	<c:when test="${empty loginId }"> <!-- 로그인화면 when 안에.. -->
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인(화면)</a>
                    	</c:when>
                    	<c:otherwise> <!-- 로그인 되었을때 글등록,로그아웃 실행가능하게.. -->
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">글등록(화면)</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
                    	</c:otherwise>
                  	</c:choose>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
                </div>
            </div>