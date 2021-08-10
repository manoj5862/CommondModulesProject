<html>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

 
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: SpringGreen;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 25px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: SpringGreen;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}

.footer {
  
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: SpringGreen;
   color: white;
   text-align: center;
}

</style>
</head>
<body>

<div class="header">
  <a href="#default" class="logo">X-Workz</a>
  
  <div class="header-right">
    <a href="#about">About</a>
  </div>
  
</div>

<h2><span style="color: Orange;">Student Enrollment Form</span></h2>
<form action="enroll.do" >
<pre>
Student Name <input type="text" name="name">
Student Email <input type="text" name="email">


<div class="container">
  <button type="submit" class="btn btn-success">Submit</button>
  </div>
  
  <div class="footer">
  <p>Copyright Xworkz @2021</p>
</div>

</pre>
</form>
</body>
</html>