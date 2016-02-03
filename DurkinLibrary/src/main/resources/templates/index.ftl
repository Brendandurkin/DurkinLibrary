<!DOCTYPE HTML>
<html>
<head> 
    <title>People</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <script src="/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<#include "/common/menubar.ftl">
	
	<h2 class="muted">Durkin Library Demo</h2>   
	 
	<p>
	The site was created to demonstrate a simple Spring MVC application.<BR>
	The data for the site is held in a H2 memory database and It is seeded on startup with some example data.<br> 
	This site has only a few very simple screens with a few actions.
	<p>
	The application is available on github and runs out of the box with "mvn jetty:run" from the command line.<br> 
	<p>
	<b>Core Features</b>:
  	<ul>
  	<li>A list of people in the database.</li>
  	<li>A list of books in the database.</li>
    <li>For each person an anchor can perform an ajax query to the database to extract the books they have lent and then display the book details inline.</li>
    </ul>
	
	<b>Tech's used</b>:
  	<ul>
  	<li>Maven as the build tool</li>
  	<li>org.mortbay.jetty</li>
  	<li>Spring MVC</li>
  	<li>Spring Boot</li>
  	<li>Bootstrap</li>
  	<li>JQuery</li>
  	<li>H2</li>
  	<li>Hibernate</li>
  	<li>Freemarker</li>
  	</ul>
	
	<b>Data Model</b>:
	<ul>
  	<li>A person has the fields : name, phone number, email address.</li>
  	<li>A Book has the fields: title, author and ISBN.</li>
  	</ul>
  	
</div>	
</body>
</html>