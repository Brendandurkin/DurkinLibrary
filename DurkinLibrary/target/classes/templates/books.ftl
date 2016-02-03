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
	
	<h2 class="muted">List Books</h2>   
	<#if books?size != 0 >
		<div>
		    <table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>ISBN</th>
		                <th>Edit</th>
		                <th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<#list books as book>
						<tr>
							<td>${book.title}</td>							
							<td>${book.author}</td>
							<td>${book.isbn}</td>
							<td><a href="${'/book/edit/' + book.id}">Edit</a></td>
							<td><a href="${'/book/delete/' + book.id}">Delete</a></td>
						</tr>
					</#list>
				</tbody>
		    </table>
	    </div>
    </#if>    
</div>	
</body>
</html>