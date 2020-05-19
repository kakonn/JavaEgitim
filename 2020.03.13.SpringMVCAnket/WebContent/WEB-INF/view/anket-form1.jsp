
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error{color:red}
</style>
</head>
<body>

<f:form action="showform2" modelAttribute="ank">
	
			Uyruk : <f:radiobutton path="uyruk" value="TC"/> T.C <br>
	<f:radiobutton path="uyruk" value="diger"/> Diger 
	<f:errors path="uyruk" cssClass="error"/><br>
	İsim : <f:input path="isim" />
	<f:errors path="isim" cssClass="error"/>
		<br>
	Soyisim : <f:input path="soyisim" />
	<f:errors path="soyisim" cssClass="error"/>
		<br>
		Cinsiyet : <f:radiobutton path="cinsiyet" value="Erkek"/> Erkek <br>
	<f:radiobutton path="cinsiyet" value="Kadin"/> Kadin 
	<f:errors path="cinsiyet" cssClass="error"/>
	<br>
	Şehir : <f:select path="sehir">
			<f:options items="${ank.sehirler}" />
		</f:select>
		<f:errors path="sehir" cssClass="error"/>
	<br>
	
	
	
<input name="Gonder" type="Submit">
	</f:form>

	
</body>
</html>