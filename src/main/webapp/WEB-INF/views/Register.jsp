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
		<a class="navbar-brand" href="#">Vaccination</a> 
		<a class="navbar-brand" class="float-right" href="#">About</a>
	</nav>
	
	<h4 style="color: Orange;">Register Here</h4>
	<h6>
	   <span style="color: red;">${OtpVerificationMessage}</span>
	</h6>
	<form action="Register.do">
		<div class="container-fluid">
			<div class="w-50">
				<label for="userName">UserName :</label> <input type="text"
					class="form-control" id="username" name="username"
					placeholder="Enter your name" >
					<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="email">Email :</label> <input type="email"
					class="form-control" id="email" name="email"
					placeholder="Enter your mail" >
					<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="vaccineType">Vaccine Type :</label> <select multiple
					class="form-control" id="vaccineType" name="vaccineType" >
					<option>Covaxin</option>
					<option>Covishield</option>
					<option>Sputnic</option>
				</select>
					<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="age">Age :</label> <input type="number"
					class="form-control" id="age" name="age"
					placeholder="Enter Age" >
						<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>	
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="phoneNo">Phone Number :</label> <input type="number"
					class="form-control" id="phonenumber" name="phonenumber"
					placeholder="Enter Phone Number" >
						<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="gender">Gender :</label> <select multiple
					class="form-control" id="gender" name="gender" >
					<option>Male</option>
					<option>Female</option>
					<option>Others</option>
				</select>
					<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="password">Password :</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter Password" >
						<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		<div class="container-fluid">
			<div class="w-50">
				<label for="confirmPassword">Confirm Password :</label> <input type="password"
					class="form-control" id="cpassword" name="cpassword"
					placeholder="Enter Conform Password" >
						<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		</br>
		</br>

		<button type="submit" class="btn btn-success btn-sm">Register</button>
		</br></br>
		
		</form>
		<footer style="background: #e5fde3;" class="page-footer font-small black">
			<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
		</footer>
	</body>
	</html>