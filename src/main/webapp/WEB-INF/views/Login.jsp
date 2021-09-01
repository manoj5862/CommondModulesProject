<!DOCTYPE html>
<html lang="en">
<head>
<title>Vaccination Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #e5fde3;">
		<a class="navbar-brand" href="#">Vaccination</a> <a
			class="navbar-brand" class="float-right" href="#">About</a>
	</nav>
	<h4 style="color: Orange;">Login Here</h4>
	<h6>
		<span style="color: Blue;">${RegisterSuccessMessage}</span>
	</h6>
	<form action="Login.do" method="get">
		<div class="container-fluid">
			<div class="w-50">
				<label for="orderFrom">Email :</label> <input type="text"
					class="form-control" id="email" name="email"
					placeholder="Enter your Email Id" >
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="orderFrom">Password :</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter Password" >
					<h6>
		<span style="color: red;">${LoginSuccessMessage}</span>
	</h6>
	<h6>
		<span style="color: red;">${LoginBlockMessage}</span>
	</h6>
	<h6>
		<span style="color: red;">${LoginEmailAndPasswordEmptyValidateMessage}</span>
	</h6>
	<h6>
		<span style="color: red;">${LoginEmailVerifyMessage}</span>
	</h6>
	<h6>
		<span style="color: red;">${LoginFailMessage}</span>
	</h6>
	<h6>
		<span style="color: red;">${ResetPasswordMessage}</span>
	</h6>
			</div>
		</div>
	</br> </br>
	<button type="submit" class="btn btn-success btn-sm">Login</button>
	<a href="reset.do">Reset</a>
	</br> </br>
	</form>
	<footer style="background: #e5fde3;"
		class="page-footer font-small black">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
</body>
</html>