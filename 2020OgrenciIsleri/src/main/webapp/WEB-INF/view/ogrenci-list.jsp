<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ogrenciler</title>

</head>

<body>
	
			<table border="1">
				<thead>
					<tr>
						<th>Öğrenci No</th>
						<th>İsim</th>
						<th>Soyisim</th>
						<th>Aktif</th>
						<th>İşlem</th>
				</thead>
				<tbody>
					<c:forEach items="${ogrenciler}" var="ogrenci">
					
					<c:url var="mezunEt" value="/ogrenci/mezun-et">
							<c:param name="ogrenciNo" value="${ogrenci.ogrenciNo}"></c:param>
						</c:url>
						<tr>
							<td>${ogrenci.ogrenciNo}</td>
							<td>${ogrenci.isim}</td>
							<td>${ogrenci.soyisim}</td>
							<td>${ogrenci.aktif}</td>
							<td>
								<button onclick="window.location.href='${mezunEt}'">Mezun Et</button>

						
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</body>
</html>