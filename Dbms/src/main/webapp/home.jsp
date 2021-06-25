<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document</title>
<link rel="stylesheet" href="HomeCSS.css">
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
                <li> <a href="ContactUs.jsp">CONTACT US</a> </li>
                <li> <a href="About.jsp">ABOUT</a>           </li>
                </ul>
                <form action="logout" method="post">
        			<div class="btn">
            			<button>Sign Out</button>
        			</div>
        		</form>
            </div>
        </nav>

        <div class="txtbx">
            <h1 id="hd">Medical Search Engine</h1>
            <br><br><br>
            <p>A disease is a particular abnormal condition that negatively affects the structure or function of all or part of an organism, and that is not due to any immediate external injury. Diseases are often known to be medical conditions that are associated with specific signs and symptoms.</p>
            <br><br>
            <div class="schbtn">
                <a href="AbtDis.jsp" class="kbtn">Know about diseases</a>
                <a href="https://www.who.int/" class="kbtn">WHO Website</a>
            </div>
        </div>
        
    </section>
<%
  response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

  if(session.getAttribute("uname")==null)
	 response.sendRedirect("Login.jsp");
%>
</body>
</html>