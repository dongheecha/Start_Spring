<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
createPage.jsp


<form action = "create">
    �̸� : <input type="text" name="name" value="${studentValid.name}" > <br />
    ���̵� : <input type="text" name="id" value="${studentValid.id}" > <br />
    <input type="submit" value="����">


</form>



</body>
</html>