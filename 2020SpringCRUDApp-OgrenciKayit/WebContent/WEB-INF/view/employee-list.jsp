<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style3.css" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
	$(window).scroll(
			function() {

				document.getElementById('stickyContent').innerHTML = document
						.getElementById('main').innerHTML;
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
						class="icon-phone icon-light"></i> Employee
				</span> <span class="text"></span>
			</a></li>
			<li><a href="/2020SpringCRUDApp-OgrenciKayit/user/endsession"
				title="Çıkış"> <span class="icon-stack"> <i
						class="icon-circle icon-stack-base"></i> <i
						class="icon-phone icon-light"></i> Çıkış
						Yap(${sessionScope.oturumIsim})
				</span> <span class="text"></span>
			</a></li>
		</ul>
	</div>
	<div id="stickyContent"></div>
	</header>

	<div id="wrapper" align="center">
		<div id="header">
			<h2 align="center">Employee Listeleme</h2>
		</div>
	</div>

	
	


	<div id="conteiner">
		<div id="content">


			<table>
				<thead>
					<tr>
						<th>Employee Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Phone Number</th>
						<th>Hire Date</th>
						<th>Salary</th>
						<th>Commission Percent</th>
						<th>Manager</th>
						<th>Job</th>
						<th>Department</th>
						<th>Transactions</th>
					</tr>
					<tr>
						<frm:form action="search" modelAttribute="ara" method="POST">
								<td></td>
							<td><frm:input path="firstName" placeholder="Ara"/></td>
							<td><frm:input path="lastName" placeholder="Ara"/></td>
							<td></td>
							<td><frm:input path="phoneNumber" placeholder="Ara"/></td>
							<td></td>
							<td></td>
							<td></td>
							<td><frm:input path="manager.firstName" placeholder="Ara"/></td>
							<td><frm:input path="job.jobTitle" placeholder="Ara"/></td>
							<td></td>
							<td><frm:button type="submit" class="button">Ara</frm:button></td>
						</frm:form>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employees}" var="em">

						<c:url var="updateLink" value="/employee/employee-guncelle">
							<c:param name="employeeId" value="${em.employeeId}"></c:param>
						</c:url>

						<c:url var="deleteLink" value="/employee/employee-delete">
							<c:param name="employeeId" value="${em.employeeId}"></c:param>
						</c:url>

						<tr>
							<td>${em.employeeId}</td>
							<td>${em.firstName}</td>
							<td>${em.lastName}</td>
							<td>${em.email}</td>
							<td>${em.phoneNumber}</td>
							<td>${em.hireDate}</td>
							<td>${em.salary}</td>
							<td>${em.commissionPercent}</td>
							<td>${em.manager.firstName}${em.manager.lastName}</td>
							<td>${em.job.jobTitle}</td>
							<td>${em.department.departmentName}</td>

							<td>
								<button onclick="window.location.href='${updateLink}'"
									class="button-guncelle">Update</button>

								<button
									onclick="if(confirm('Silinecek, Emin Misin?'))window.location.href='${deleteLink}'"
									class="button-sil">Delete</button>

							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<button onclick="window.location.href='employee-ekle'" class="button">Employee
				Add</button>
		</div>

	</div>
</body>
</html>