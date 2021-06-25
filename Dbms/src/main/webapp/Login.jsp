<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="LoginCSS.css">
</head>
<body>
    
    <header class="header">
        
        <div class="logo">
           
        </div>

        <div class="nav">
            <div class="navbar">
                <a href="home.jsp">HOME</a>
                <a href="Login.jsp">LOGIN</a>
                <a href="SignUp.jsp">SIGN UP</a>
                <a href="ContactUs.jsp">CONTACT US</a>
                <a href="About.jsp">ABOUT</a>
            </div>
        </div>

    </header>

    <div class="mainclass">
        <div class="leftform"></div>
        <div class="rightform">
            <h2>Login</h2>
            <form id="form" action="Login" method="post">
                <label>Username</label>
                <input type="text" name="username" placeholder="Enter your name" required>

              
                <label>Password</label>
                <input type="password" name="password" placeholder="Enter your password" required>

               <div id="ss">
                  <button id="sub" type="submit">Submit</button>
               </div>
            
            </form>

            <div class="below">
                <h3 id="msg">Login with</h3>
                <button id="fb" class="sn"><i class="fa fa-facebook"> Facebook </i></button>

                <button id="google" class="sn"><i class="fa fa-google"> Google </i></button>
            </div>
        </div>
    </div>
    
</body>
</html>
