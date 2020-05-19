<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kitaplar</title>

</head>

<body>
	
			
			<f:form action="kitap-teslim" modelAttribute="kitaplar" method="POST">
				
			<table>

				<tr>
					<td><label>Kitap Id</label></td>
					<td><f:input path="id"/></td>
				</tr>
				<tr>
					<td><label>Kitap Adi</label></td>
					<td><f:input path="kitapAdi"/></td>
				</tr>

				<tr>
					<td><label>Yazar</label></td>
					<td><f:input path="yazar"/></td>
				</tr>
				
				<tr>
					<td><label>Ogrenci No</label></td>
					<td><f:input path="ogrenci.ogrenciNo" /></td>
				</tr>
				
				<tr>
					<td>${hata}</td>
					<td><f:button value="save" name="save">Teslim Et</f:button></td>
				</tr>

			</table>

			
			</f:form>
</body>
</html>