<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hi</title>
<style>
body {
   	background: #1D1B26;
  background-repeat: no-repeat;
}

h2{
color:white;
}
input[type=submit] {  

  background:none;
  text-decoration: none;
  outline: none;
  color: white;
  display: inline-block;
  position: relative;
  padding: 15px 30px;
  border: 1px solid;
  border-image: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);
  border-image-slice: 1;
  margin: 10px 20px;   font-family: 'Montserrat', sans-serif;
  text-transform: uppercase;
  overflow: hidden;
  letter-spacing: 2px;
  transition: .8s cubic-bezier(.165,.84,.44,1);
}
input[type=submit]:before {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  height: 0;
  width: 100%;
  z-index: -1;
  color: white;
  background: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);
  transition: .8s cubic-bezier(.165,.84,.44,1);
}
input[type=submit]:hover {background: rgba(255,255,255,0);}
input[type=submit]:hover:before {
  bottom: 0%;
  top: auto;
  height: 100%;
}
</style>
</head>
<body>
<div class="login" align="center">
	<form action="LoginServlet" method="post">
		<h2>Login</h2>
		<input type="text" name="login" required>
		<h2>Password</h2>
		<input type="password" name="password" required><br><br>
   		<input type="submit" value="Log in"><br><br>
	</form>	
	<form action="LoginGuestServlet" method="post">
		<input type="submit" value="Log in as guest"><br><br>
	</form>
</div>
</body>
</html>

