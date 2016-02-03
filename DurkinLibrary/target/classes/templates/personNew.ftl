<!DOCTYPE HTML>
<html>
<head> 
    <title>Person Form</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <script src="../js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">

	<#include "/common/menubar.ftl">
	
	<h2 class="muted">New Person</h2>
    <div>
        <form class="form-horizontal" name="person" action="/person" method="post">
            <input type="hidden" name="id"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">Name:</label>
                <div class="col-sm-10">
                    <input type="text" name="name" placeholder="New persons name"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Phone:</label>
                <div class="col-sm-10">
                    <input type="text" name="phone" placeholder="New persons phone"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Email:</label>
                <div class="col-sm-10">
                    <input type="text" name="email" placeholder="New persons email"/>
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