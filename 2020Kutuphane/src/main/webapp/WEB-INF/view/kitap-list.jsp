<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kitaplar</title>

</head>

<body>
	
			<table border="1">
				<thead>
					<tr>
						<th>Kitap Id</th>
						<th>Kitap Adı</th>
						<th>Yazar</th>
						<th>Bulundugu Ogrenci No</th>
						<th>İşlem</th>
						
				</thead>
				<tbody>
					<c:forEach items="${kitaplar}" var="kitap">
						
						<c:url var="kitapLink" value="/kitaplar/kitap-ekle">
							<c:param name="kitapId" value="${kitap.id}" />
						</c:url>
						
						<tr>
							<td>${kitap.id}</td>
							<td>${kitap.kitapAdi}</td>
							<td>${kitap.yazar}</td>
							<td>${kitap.ogrenci.ogrenciNo}</td>
							<td>
								<button onclick="window.location.href='${kitapLink}'">Kitabı Ver</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
</body>
</html>