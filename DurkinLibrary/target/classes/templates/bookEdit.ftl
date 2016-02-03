<!DOCTYPE HTML>
<html>
<head> 
    <title>Book Form</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <script src="../js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<#include "/common/menubar.ftl">
	<h2 class="muted">Edit Book Details</h2>
    <div>
        <form class="form-horizontal" name="book" action="/book" method="post">
            <input type="hidden" name="id" value="${book.id}"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">Name:</label>
                <div class="col-sm-10">
                    <input type="text" name="title" value="${book.title}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Author:</label>
                <div class="col-sm-10">
                    <input type="text" name="author" value="${book.author}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">ISBN:</label>
                <div class="col-sm-10">
                    <input type="text" name="isbn"  value="${book.isbn}"/>
                </div>
            </div>
            <div class="row">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </form>
    </div>
</div>	
</body>
</html>