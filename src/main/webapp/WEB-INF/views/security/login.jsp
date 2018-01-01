<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<h1>login.jsp</h1>

<%-- <c:if test="${not empty pageContext.request.userPrincipal }">
    <p>is LOG-in</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal }">
    <p>is LOG-out</p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name} <br />
<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
 --%>
 
 <s:authorize ifAnyGranted="ROLE_USER">
 <p> is Log-in</p>
 </s:authorize>
 
 <s:authorize ifNotGranted="ROLE_USER">
 <p> is Log-out</p>
 </s:authorize>
 
 User Id : <s:authentication property="name" /> <br />
 <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
 
 
</body>
</html>