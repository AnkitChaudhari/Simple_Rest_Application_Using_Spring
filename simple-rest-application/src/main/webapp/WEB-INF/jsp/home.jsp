<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myRestApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List</title>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/controller.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/css/bootstrap-theme.min.css">

</head>
<body ng-controller="myRestCtrl">
<div align="center"><h3><b>Welcome To Contact List Management System</b></h3></div><br>
<div class="container">
<table class="table">
<thead>
<tr>
<th>Name</th>
<th>Email</th>
<th>Contact Details</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="contact in contactlist">
<td>{{contact.name}}</td>
<td>{{contact.email}}</td>
<td>{{contact.number}}</td>
</tr>
</tbody>
</table>
</div>

</body>
</html>