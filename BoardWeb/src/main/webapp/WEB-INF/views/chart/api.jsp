<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <ul id="list"></ul> -->

<select class="form-control" id="centerList">
	<option>선택하세요</option>
	<option>경기도</option>
	<option>서울특별시</option>
	<option>인천광역시</option>
</select>

<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>센터명</th>
			<th>연락처</th>
			<th>시도</th>
		</tr>
	</thead>
	<tbody id="list">
	</tbody>
</table>

<script src="js/api.js"></script>
<!-- 
<script src="js/array.js"></script> 
 -->