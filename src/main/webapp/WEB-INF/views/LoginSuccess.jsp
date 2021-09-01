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
			class="navbar-brand" class="float-right" href="#">
			</a>
			<h6>${UserName}</h6>
	</nav>
	<nav class="navbar navbar-light" style="background-color: #e5fde3;">
		<a class="navbar-brand" href="#"></a> <a
			class="navbar-brand" class="float-right" href="#">
			</a>	
			<form action="logout.do">
	<button type="submit" class="btn btn-success btn-sm">Logout</button>
	</form>
	</nav>
	
	<h6>
		<span style="color: Green;">${LoginSuccessMessage}</span>
	</h6>
	
	<form action="AddMemberPage.do">
	<button type="submit" class="btn btn-success btn-sm">AddMember</button>
	</form>
</br>
	<form action="EditMemberPage.do">
	<button type="submit" class="btn btn-success btn-sm">EditMember</button>
	</form>
	</br>
	<form action="DeleteMemberPage.do">
	<button type="submit" class="btn btn-success btn-sm">DeleteMember</button>
	</form>
<footer style="background: #e5fde3;"
		class="page-footer font-small black">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
</body>
</html>