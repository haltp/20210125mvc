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
		<h1>게시글 작성</h1>
		<div>
			<form id="frm" name="frm" action="/20210125mvc/BoardInput.do"
				method="post">
				<table border="1">
					<tr>
						<th width="60">글번호</th>
						<td align="center" width="50"><input type="text" id="boardNo"
							name="boardNo"></td>
						<th width="100">작성자</th>
						<td align="center" width="100"><input type="text" id="writer"
							name="writer"></td>
						<th width="100">작성일자</th>
						<td align="center" width="100"><input type="date" id="creationDate"
							name="creationDate"></td>
					</tr>
					<tr>
						<th width="50">제 목</th>
						<td colspan="5"><input type="text" id="title" name="title"
							size="95"></td>
					</tr>
					<tr>
						<th width="50">내용</th>
						<td colspan="5"><textarea id="content" name="content"
								rows="7" cols="70"></textarea></td>
					</tr>
					<br />
				</table>
				<div>
					<button type="submit">저장하기</button>
					&nbsp;&nbsp;
					<button type="reset">취소</button>
				</div>
			</form>
		</div>


	</div>
</body>
</html>