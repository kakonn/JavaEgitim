<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	Uyruk : ${ank.uyruk} <br>
	Personel First Name : ${ank.isim} <br>
	Personel Last Name : ${ank.soyisim} <br>
	Cinsiyet : ${ank.cinsiyet}<br>
	Sehir : ${ank.sehir}<br>
	E-Posta : ${ank2.eposta}<br>
	Adres : ${ank2.adres}<br>
	Okul : ${ank2.okul}<br>
	Bolum : ${ank2.bolum}<br>
	Okul : <br>
	<ul>
	<c:forEach var="rec" items="${kisi.sideBenefits}">
		
		<li>${rec}</li>
	
	</c:forEach>
	
	
	</ul>
	
	
</body>
</html>