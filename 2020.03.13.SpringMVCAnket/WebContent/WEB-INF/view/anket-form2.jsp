
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<f:form action="saveform" modelAttribute="ank">
	

	E-Posta : <f:input path="eposta" />
	<f:errors path="eposta" cssClass="error"/>
		<br>
	Adres : <f:input path="adres" />
	<f:errors path="adres" cssClass="error"/>
		<br>
		
	Okul : <f:select path="okul">
			<f:options items="${ank.okullar}" />
		</f:select>
		<f:errors path="okul" cssClass="error"/>
	<br>
	Bolum : <f:select path="bolum">
			<f:options items="${ank.bolumler}" />
		</f:select>
		<f:errors path="bolum" cssClass="error"/>
	<br>
	
<input name="Gonder" type="Submit">
	</f:form>

	
</body>
</html>