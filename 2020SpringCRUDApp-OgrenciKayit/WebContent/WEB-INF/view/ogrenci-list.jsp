<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ogrenciler</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style3.css" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
	$(window).scroll(function() {

		document.getElementById('stickyContent').innerHTML = document.getElementById('main').innerHTML;
	});
</script>

</head>

<body>
	<header>
	<div id="main" class="duplicate">
		<ul class="nav">
			<li><a href="/2020SpringCRUDApp-OgrenciKayit/user/welcome"
				title="Home"> <span class="icon-stack"> <i
						class="icon-circle icon-stack-base"></i> <i
						class="icon-home icon-light"></i>
				</span>Home <span class="text"></span>
			</a></li>
			<li><a href="/2020SpringCRUDApp-OgrenciKayit/ogrenci/list"
				title="Ogrenci"> <span class="icon-stack"> <i
						class="icon-circle icon-stack-base"></i> <i
						class="icon-home icon-light"></i>
				</span>Ögrenci <span class="text"></span>
			</a></li>
			<li><a href="/2020SpringCRUDApp-OgrenciKayit/kurs/list"
				title="Kurs"> <span class="icon-stack"> <i
						class="icon-circle icon-stack-base"></i> <i
						class="icon-leaf icon-light"></i>
				</span>Kurs <span class="text"></span>
			</a></li>
			<li><a href="/2020SpringCRUDApp-OgrenciKayit/employee/list"
				title="Employee"> <span class="icon-stack"> <i
						class="icon-circle icon-stack-base"></i> <i
						class="icon-phone icon-light"></i>
				Employee</span> <span class="text"></span>
			</a></li>
			<li><a href="/2020SpringCRUDApp-OgrenciKayit/user/endsession"
				title="Çıkış"> <span class="icon-stack"> <i
						class="icon-circle icon-stack-base"></i> <i
						class="icon-phone icon-light"></i>
				Çıkış Yap(${sessionScope.oturumIsim})</span> <span class="text"></span>
			</a></li>
		</ul>
	</div>
	<div id="stickyContent"></div>
	</header>

	<div id="wrapper" align="center">
		<div id="header">
			<h2>Ögrenci Listeleme</h2>
		</div>

	</div>


	<div id="conteiner" align="center">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>İsim</th>
						<th>Soyisim</th>
						<th>Öğrenci No</th>
						<th>İşlem</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ogrenciler}" var="ogrenci">

						<c:url var="updateLink" value="/ogrenci/ogrenci-guncelle">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>

						<c:url var="deleteLink" value="/ogrenci/ogrenci-sil">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>
						
						<tr>
							<td>${ogrenci.id}</td>
							<td>${ogrenci.isim}</td>
							<td>${ogrenci.soyisim}</td>
							<td>${ogrenci.ogrenciNo}</td>
							<td>
								<button onclick="window.location.href='${updateLink}'"
									class="button-guncelle">Güncelle</button>
									<button onclick="if(confirm('Siliyoruz, emin misin?'))window.location.href='${deleteLink}'"
									class="button-sil">Sil</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<button onclick="window.location.href='ogrenci-ekle'" class="button">Öğrenci
				Ekle</button>
		</div>

	</div>

</body>
</html>