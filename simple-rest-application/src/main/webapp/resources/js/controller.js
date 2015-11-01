var app = angular.module('myRestApp', []);
app.controller('myRestCtrl', function($scope,$http) {
	var SERVER_ENDPOINT="http://localhost:3000/simple-rest-application";
	$scope.contactlist=[];
	$http.get(SERVER_ENDPOINT+"/getContacts").success(function(data){
		$scope.contactlist=data;
	}).error(function(error){
		alert("ERROR!!!")
	});
});