<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<f:form action="showform2" modelAttribute="dp">
Department Id : <f:input path="departmentId" />
		<input name="Ara" type="Submit" value="Bul">
		<hr>
		
	</f:form>
	<f:form action="showform3" modelAttribute="dp">
	Department Id : <f:input path="departmentId" disabled="true"/><br>
		Department Name : <f:input path="departmentName" disabled="${departmentController.sorgu}"/><br>
		Manager Id : <f:input path="managerId" disabled="${departmentController.sorgu}"/><br>
		Location Id : <f:input path="locationId" disabled="${departmentController.sorgu}"/><br>
		<input name="Guncelle" type="Submit" value="Guncelle">
	</f:form>
	<f:form action="showform4" modelAttribute="dp">
	<input name="Sil" type="Submit" value="Sil">
	</f:form>
</body>
</html>