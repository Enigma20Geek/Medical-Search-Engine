# Medical-Search-Engine
A Java Web Application using JSP and Servlet API to get information about diseases and medicines.


## Medical Search Engine Project Compiling and Running Instructions ##

(JAVA files are in Dbms/src/main/java folder and JSP/CSS files are in Dbms/src/main/webapp folder)

Requirements:

1) Java version 14 or above should be installed on the system.

2) Java EE Eclipse IDE with Apache Tomcat v10.0 Configured.

3) Add the 4 *.jar files(included with the zip) to the project.
	mysql-connector-java-8.0.23.jar,activation-2.2.1.jar,javax.mail.jar these 3 files should be added to /lib folder of Tomcat installation directory.
	javax.servlet.jar should be added to classpath of the project.

4) MySQL database should be installed on the system and the mentioned database with mentioned 4 tables should be created in the MySQL Workbench.
	med_info,disease_info,disease_info1 tables should be updated beforehand with the same data as in CSV files.
	(Code is needed to be updated in DiseaseInfo.java,Form.java,LoginDao.java with the system's MySQL username and password)

5) Open the project in the Eclipse IDE and run the home.jsp file by right clicking it and choosing Run > Run on server > Finish.
