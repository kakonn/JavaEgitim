<%@page import="javafx.scene.control.Alert.AlertType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
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
		</ul>
	</div>
	<div id="stickyContent"></div>
	</header>

<div class="login-wrap">
	<div class="login-html">
	
	${basarili}
	${giris}
	
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
		<div class="login-form">
			<div class="sign-in-htm">
			
			<frm:form action="${pageContext.request.contextPath}/user/login-success"
		method="POST" modelAttribute="user-login">
				<div class="group">
				<%
	HttpSession ses = request.getSession();
	String kontrol = (String)ses.getAttribute("oturum-email");
	if(kontrol==null){
		out.print("Lütfen Önce Giriş Yap !");
	}
	%>
					<label for="user" class="label">Email</label>
					<frm:input id="user-login.email" type="text" class="input" path="email"/><frm:errors path="email" cssClass="error"/>
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<frm:input id="user-login.password" type="password" class="input" path="password"/><frm:errors path="password" cssClass="error"/>
					${error}
				</div>
				<div class="group">
				
					<input type="submit" class="button" value="Sign In"/>
				
				</div>
					</frm:form>
				
				<div class="hr"></div>
			
			</div>
			<div class="sign-up-htm">
		
			<frm:form action="/2020SpringCRUDApp-OgrenciKayit/user/register-success"
		method="POST" modelAttribute="user">
				<div class="group">
					<label for="user" class="label">Name</label>
					<frm:input id="user.name" type="text" class="input" path="name"/>
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<frm:input id="user.password" type="password" class="input" path="password"/>
				</div>
				<div class="group">
					<label for="user.email" class="label">Email Address</label>
					<frm:input id="user.email" type="text" class="input" path="email"/>
				</div>
				<div class="group">
					<label for="pass" class="label">Male</label>
					<frm:radiobutton id="user.gender" class="input" path="gender" value="Male"/>
					<label for="pass" class="label">Female</label>
					<frm:radiobutton id="user.gender" class="input" path="gender" value="Female"/>
				</div>
				<div class="group">
					<label for="pass" class="label">Phone Number</label>
					<frm:input id="user.phone" type="text" class="input" path="phone"/>
				</div>
				<div class="group">
					
					<input type="submit" class="button" value="Sign Up">
				</div>
				</frm:form>
			
				<div class="hr"></div>
			</div>
		</div>
	</div>
</div>

</body>
</html>