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

	<h4 style="color: Orange;">OTP Verifacation</h4>
	<form action="OTPVerify.do" method="get">
		<div class="container-fluid">
			<div class="w-50">
				<label for="orderFrom">Enter OTP :</label> <input type="number"
					class="form-control" id="enteredOtp" name="enteredOtp"
					placeholder="Enter OTP" >
					<h6>
		                <span style="color: red;">${OtpVerificationMessage}</span>
	               </h6>
	               
			</div> 
		</div>
	</br> </br>
	<button type="submit" class="btn btn-success btn-sm">VerifyOTP</button>
	</br> </br>
	</form>
	<footer style="background: #e5fde3;"
		class="page-footer font-small black">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
</body>
</html>
