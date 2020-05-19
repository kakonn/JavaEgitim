<%@page import="javafx.scene.control.Alert"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Formu</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
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
	$(document)
			.ready(
					function() {
						$('#comboboxDepartment')
								.on(
										'change',
										function() {
											var departmentId = $(
													'#comboboxDepartment option:selected')
													.val();
											$
													.ajax({
														type : 'GET',
														url : '${pageContext.request.contextPath }/employee/load/'
																+ departmentId,
														success : function(
																result) {
															//console.log(result);
															var result = JSON
																	.parse(result);
															var s = '';
															for (var i = 0; i < result.length; i++) {
																if (result != null) {
																	s += '<option value="' + result[i].employeeId + '">'
																			+ result[i].firstName
																			+ " "
																			+ result[i].lastName
																			+ '</option>';
																} else {
																	s = '<option value="-1"> </option>';
																}
															}
															$(
																	'#comboboxManager')
																	.html(s);
														}
													});
										});
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
			<h2>Ogrenci Formu</h2>
		</div>
		<frm:form action="employee-update" modelAttribute="employee"
			method="POST">
			<frm:hidden path="employeeId" />
		
			<table align="center" border="1">

				<tr>
					<td><label>First Name</label></td>
					<td><frm:input path="firstName" /></td>
					<td><frm:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><frm:input path="lastName" /></td>
					<td><frm:errors path="lastName" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label>Email</label></td>
					<td><frm:input path="email" /></td>
					<td><frm:errors path="email" cssClass="error" /> ${lastna}</td>
				</tr>

				<tr>
					<td><label>Salary</label></td>
					<td><frm:input path="salary" /></td>
					<td><label>${error}<frm:errors path="salary"
								cssClass="error" /></label></td>

				</tr>

				<tr>
					<td><label>Commission Percent</label></td>
					<td><frm:input path="commissionPercent" /></td>
					<td></td>
				</tr>

				<tr>
					<td><label>Phone</label></td>
					<td><frm:input path="phoneNumber" /></td>
					<td><frm:errors path="phoneNumber" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label>Hire Date</label></td>
					<td><frm:input type="date" path="hireDate" /></td>
					<td><frm:errors path="hireDate" cssClass="error" /></td>
				</tr>

				<tr>

					<td><label>Department</label></td>
					<td><frm:select id="comboboxDepartment"
							path="department.departmentId">
							<frm:options items="${departments}" />

						</frm:select></td>
					<td><frm:errors path="department.departmentId"
							cssClass="error" /></td>

				</tr>

				<tr>
					<td><label>Manager</label></td>

					<td><frm:select id="comboboxManager" path="manager.employeeId">

						</frm:select></td>
					<td></td>
				</tr>

				<tr>

					<td><label>Job</label></td>
					<td><frm:select path="job.jobId">

							<frm:options items="${jobs}" />

						</frm:select></td>

					<td></td>
				</tr>



				<tr>
					<td></td>
					<td><frm:button type="submit" class="button">Kaydet</frm:button></td>
					<td></td>
				</tr>

			</table>

		</frm:form>
	</div>


	<div id="container">
		<div id="content"></div>
	</div>

</body>
</html>

