<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		
            <c:if test="${dto.deleteflag eq 0}">
				<tr>
	
					<td>${dto.bid}</td>
					<td>${dto.bname}</td>
					<td><c:forEach begin="1" end="${dto.bindent}">-</c:forEach> <a
						href="contentView.html?id=${dto.bid}">${dto.btitle}</a></td>
					<td>${dto.bdate}</td>
					<td>${dto.bhit}</td>
				</tr>
            </c:if>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writeView.html">글작성</a></td>
		</tr>
	</table>

</body>
</html>