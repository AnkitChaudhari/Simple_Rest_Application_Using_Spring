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
	<div align="center">
		<h2>
			<b>Welcome To Contact List Management System</b>
		</h2>
	</div>
	<br>
	<div class="container">
		<table class="table">
			<thead align="center">
				<tr>
					<th style="text-align: center;">Name</th>
					<th style="text-align: center;">Email</th>
					<th style="text-align: center;">Contact Details</th>
					<th colspan="2" style="text-align: center;">Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr align="center">
					<td><input class="form-control" ng-model="contact.name" data-toggle="tooltip" title="Enter First Name and Last Name Seperated By Space"></td>
					<td><input class="form-control" ng-model="contact.email" data-toggle="tooltip" title="Enter Email Id"></td>
					<td><input class="form-control" ng-model="contact.number" data-toggle="tooltip" title="Enter Phone Number"></td>
					<td><button class="btn btn-success" ng-click="addContact()">Add
							New Contact</button></td>
					<td><button class="btn btn-primary" ng-click="updateContact()">Update
							Contact</button></td>
					<td><button class="btn btn-warning" ng-click="clear()">
							Clear</button></td>
				</tr>
				<tr ng-repeat="contact in contactlist" align="center">
					<td>{{contact.name}}</td>
					<td>{{contact.email}}</td>
					<td>{{contact.number}}</td>
					<td><button class="btn btn-danger"
							ng-click="deleteContact(contact.id)">Delete Contact</button></td>
					<td><button class="btn btn-info"
							ng-click="editContact(contact.id)">Edit Contact</button></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>