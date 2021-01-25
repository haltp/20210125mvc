<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/menu.jsp" />
</head>
<body>
	<div align="center">
		<h1>게시글 상세보기</h1>
		<div>
			<table border="1">
				<tr>
					<th width="50">글번호</th>
					<td align="center" width="50">${vo.boardNo }</td>
					<th width="100">작성자</th>
					<td align="center" width="100">${vo.writer }</td>
					<th width="100">작성일자</th>
					<td align="center" width="100">${vo.creationDate }</td>
				</tr>
				<tr>
					<th width="50">제 목</th>
					<td colspan="5">&nbsp;${vo.title }</td>
				</tr>
				<tr>
					<th width="50">내용</th>
					<td colspan="5"><textarea rows="7" cols="70">${vo.content }</textarea></td>
				</tr>
			</table><br/>
			<button type="button" onclick="location.href='/20210125mvc/BoardList.do'">목록 보기</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/20210125mvc/BoardDelete.do?row='+${vo.boardNo }">삭제</button>
		</div>
	</div>
</body>
</html>