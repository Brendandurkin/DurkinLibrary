<!DOCTYPE HTML>
<html>
<head> 
    <title>People</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <script type="text/javascript" src="/js/jquery-2.2.0.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script> 
    <script type="text/javascript">
    ( function($) {
		$(document).ready( function() { 					
			$(".personBooks").click(function(event){
				var $td = $(this).closest("td");
			    var id= $td.attr("id");
       			
			    $.get({
			        url:  "/person/books/"+id,
			        dataType: "json",
			        success: function(response){			        
			        	var info = "";
			        	if (response.status=="SUCCESS") {
				        	var res = response.result;						
				        	info = "<ul>";
				        	for(i =0 ; i < response.result.length ; i++){
		                        info += "<br><li><a href='/book/edit/"+response.result[i].id+"'>" + response.result[i].title +
		                     	"</a> (ISBN : " + response.result[i].isbn + ")";
		                 	}
		                 	info += "</ul>";
	                 	} else {
	                 		info = "<i>no books found</i>";
	                 	}
	                 	$td.html(info);	                 			           
			         }
			    });

       			event.preventDefault();
	    
     		});
     
		} );
	} ) ( jQuery );
     
    </script>
</head>
<body>
	<div class="container">
		<#include "/common/menubar.ftl">

	<h2 class="muted">List People</h2>
	<#if people?size != 0 >
		<div>
		    <table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Books</th>
		                <th>Edit</th>
		                <th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<#list people as person>
						<tr>
							<td>${person.name}</td>							
							<td>${person.phone}</td>
							<td>${person.email}</td>
							<td id="${person.id}"><a href="#" class="personBooks" >Click here to fetch Books for this person</a></td>
							<td><a href="${'/person/edit/' + person.id}">Edit</a></td>
							<td><a href="${'/person/delete/' + person.id}">Delete</a></td>
						</tr>
					</#list>
				</tbody>
		    </table>
	    </div>
    </#if>    
</div>	
</body>
</html>