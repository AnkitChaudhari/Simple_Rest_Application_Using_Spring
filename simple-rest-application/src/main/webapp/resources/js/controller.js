var app = angular.module('myRestApp', []);
app.controller('myRestCtrl', function($scope,$http) {
	var SERVER_ENDPOINT="http://localhost:3000/simple-rest-application";
	$scope.contactlist=[];
	$scope.modalHeader="";
	$scope.modalContent="";
	$scope.contact={
			id:null,
			name:"",
			email:"",
			number:""
	};
	var refresh=function()
	{
		$http.get(SERVER_ENDPOINT+"/getContacts").success(function(data){
			$scope.contactlist=data.body;
			$scope.contact.name="";
			$scope.contact.email="";
			$scope.contact.number="";
		}).error(function(error){
			$scope.modalContent="Our servers are under maintainance. Please try again after some time";
			$scope.modalHeader="Failure";
			$('#myModal').modal('show');
		});	
	};
	
	refresh();
	
	
	$scope.addContact=function()
	{
		$http.post(SERVER_ENDPOINT+"/addContact",$scope.contact).success(function(data){
			if(data.responseHeader.code=="0000")
			{
				$scope.modalContent="Contact has been added to your contactlist";
				$scope.modalHeader="Success";
				$('#myModal').modal('show');
				refresh();
			}
			else
			{
				$scope.modalContent=data.body;
				$scope.modalHeader="Failed";
				$('#myModal').modal('show');
			}
			
		}).error(function(error){
			$scope.modalContent="Our servers are under maintainance. Please try again after some time";
			$scope.modalHeader="Failure";
			$('#myModal').modal('show');
		});
	};
	
	$scope.deleteContact=function(id)
	{
		$http.delete(SERVER_ENDPOINT+"/deleteContact/"+id).success(function(data){
			$scope.modalContent="Contact has been deleted from your contactlist";
			$scope.modalHeader="Success";
			$('#myModal').modal('show');
			refresh();
		}).error(function(error){
			$scope.modalContent="Our servers are under maintainance. Please try again after some time";
			$scope.modalHeader="Failure";
			$('#myModal').modal('show');
		});
	};
	
	$scope.editContact=function(id)
	{
		$http.put(SERVER_ENDPOINT+"/editContact/"+id).success(function(data){
			$scope.contact=data.body;
		}).error(function(error){
			$scope.modalContent="Our servers are under maintainance. Please try again after some time";
			$scope.modalHeader="Failure";
			$('#myModal').modal('show');
		});
	};
	
	$scope.updateContact=function()
	{
		$http.post(SERVER_ENDPOINT+"/updateContact",$scope.contact).success(function(data){
			if(data.responseHeader.code=="0000")
			{
				$scope.modalContent="Contact has been updated successfully";
				$scope.modalHeader="Success";
				$('#myModal').modal('show');
				refresh();
				
			}
			else
			{
				$scope.modalContent=data.body;
				$scope.modalHeader="Failed";
				$('#myModal').modal('show');
			}
			
		}).error(function(error){
			$scope.modalContent="Our servers are under maintainance. Please try again after some time";
			$scope.modalHeader="Failure";
			$('#myModal').modal('show');
		});
		
	};
	
	$scope.clear=function()
	{
		$scope.contact.id=null;
		$scope.contact.name="";
		$scope.contact.email="";
		$scope.contact.number="";
	};
	
});