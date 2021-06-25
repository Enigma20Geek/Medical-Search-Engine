<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="AbtDisCSS.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;400;600;700&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Orelega+One&display=swap" rel="stylesheet">
</head>
<body>
    <section class="header">
        <nav>
            <div class="navlinks">
                <ul>
                <li> <a href="home.jsp">HOME</a>        </li>
                <li> <a href="Login.jsp">LOGIN</a>       </li>
                <li> <a href="SignUp.jsp">SIGNUP</a>      </li>
                <li> <a href="ContactUs.jsp">CONTACT US</a></li>
                <li> <a href="About.jsp">ABOUT</a>                  </li>
                </ul>
            </div>
            <form action="logout" method="post">
        		<div class="btn">
            		<button>Sign Out</button>
        		</div>
        	</form>
        </nav>
        <div class="txtbx">
           	<h2>Know About Diseases!</h2>

           	<form id="form" action="view" method="post">
               	<label id="nameL">Name</label>
               	<input type="text" name="Name" placeholder="Enter the name of the disease" required>

              	<div id="ss">
               	  <button id="sub">Search</button>
              	</div>
           
           	</form>
       	</div>
        
    </section>
        <%
  response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

  if(session.getAttribute("uname")==null)
	 response.sendRedirect("Login.jsp");
%>

</body>
</html>