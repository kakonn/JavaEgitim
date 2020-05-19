<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kurs Listesi</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
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
			<h2>Kurs Formu</h2>
		</div>
		<frm:form action="kurs-kaydet" modelAttribute="kurs" method="POST">
		<frm:hidden path="id"/>
			<table align="center">

				<tr>
					<td><label>Kurs Adı</label></td>
					<td><frm:input path="kursAdi" /></td>
				</tr>
				<tr>
					<td><label>Saat</label></td>
					<td><frm:input path="saat" /></td>
				</tr>
				<tr>

					<td><label>Öğretmen</label></td>
					<td><frm:select path="ogretmen.id">

							<frm:options items="${ogretmenler}" />

						</frm:select></td>

				</tr>
			</table>
			<hr>
			<button type="submit" class="button">Kaydet</button>
		</frm:form>

	</div>
</body>
</html>