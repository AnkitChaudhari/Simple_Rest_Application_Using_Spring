var app = angular.module('myRestApp', []);
app.controller('myRestCtrl', function($scope,$http) {
	var SERVER_ENDPOINT="http://localhost:3000/simple-rest-application";
	$scope.contactlist=[];
	
	var refresh=function()
	{
		$http.get(SERVER_ENDPOINT+"/getContacts").success(function(data){
			$scope.contactlist=data.body;
			$scope.contact="";
		}).error(function(error){
			alert("INTERNAL SERVER ERROR!!");
		});	
	};
	
	refresh();
	
	
	$scope.addContact=function()
	{
		$http.post(SERVER_ENDPOINT+"/addContact",$scope.contact).success(function(data){
			alert("Contact Added To Your ContactList!!");
			refresh();
		}).error(function(error){
			alert("INTERNAL SERVER ERROR!!");
		});
	};
	
	$scope.deleteContact=function(id)
	{
		$http.delete(SERVER_ENDPOINT+"/deleteContact/"+id).success(function(data){
			alert("Contact deleted from your contactlist");
			refresh();
		}).error(function(error){
			alert("INTERNAL SERVER ERROR!!");
		});
	};
	
	$scope.editContact=function(id)
	{
		$http.put(SERVER_ENDPOINT+"/editContact/"+id).success(function(data){
			$scope.contact=data.body;
		}).error(function(error){
			alert("INTERNAL SERVER ERROR!!");
		});
	};
	
	$scope.updateContact=function()
	{
		$http.post(SERVER_ENDPOINT+"/updateContact",$scope.contact).success(function(data){
			alert("Contact Updated Successfully");
			refresh();
			$scope.contact="";
		}).error(function(error){
			alert("INTERNAL SERVER ERROR!!");
		});
		
	};
	
	$scope.clear=function()
	{
		$scope.contact="";
	};
	
});