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
	
	<h4 style="color: Orange;">Add Members For Vaccination</h4>
	
	<form action="AddMember.do">
		<div class="container-fluid">
			<div class="w-50">
				<label for="userName">Name :</label> <input type="text"
					class="form-control" id="username" name="name"
					placeholder="Enter your name" >
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
				<label for="confirmPassword">Aadhaar No :</label> <input type="number"
					class="form-control" id="aadhaar" name="aadhar"
					placeholder="Enter Aadhaar Number" >
						<h6>
	   <span style="color: red;">${ErrorMessage}</span>
	       </h6>
			</div>
		</div>
		</br>
		</br>

		<button type="submit" class="btn btn-success btn-sm">Add</button>
		</br></br>
		
		</form>
		<footer style="background: #e5fde3;" class="page-footer font-small black">
			<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
		</footer>
	</body>
	</html>