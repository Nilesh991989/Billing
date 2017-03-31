app.controller('historyController', ['$scope','$http','$rootScope','$location',function ($scope,$http,$rootScope,$location) {
   $scope.historyItems = [];	
   $scope.noRecordFoundFlag = true;
   
	if($rootScope.token === undefined){
		$location.path('/login');
	}
   
   var config = {
           headers : {'Content-Type': 'application/json',
           	       'Authorization': 'Bearer ' + $rootScope.token }
       }
   
   $scope.showData = function( ){
	 $scope.curPage = 0;
	 $scope.pageSize = 5;
     $scope.numberOfPages = function() {
			return Math.ceil($scope.historyItems.length / $scope.pageSize);
	 };	         
   };
   
   $scope.fetchRecord = function(){
	     var url = "http://localhost:8080/api/getbill/" + $scope.merchantname; 
	     $http.get(url,config).then(function(response) {
		    	$scope.historyItems = response.data;
		    	$rootScope.historyItems = $scope.historyItems;			     
   		        if($scope.historyItems.length == 0){
			    	 $scope.noRecordFoundFlag = false
			     }else{
			    	 $scope.noRecordFoundFlag = true
			     }
			     $scope.showData();
		 });
	     
   }
   
   $scope.showBillDetail=function(billid){
	   for(var i = 0; i < $scope.historyItems.length; i++){
	       if($scope.historyItems[i].billid == billid){
	    	   $rootScope.selectedBillDetail = $scope.historyItems[i];          
	       }
	     }
	   $location.path('/billdetail');
   }  
   
}]);

angular.module('app').filter('pagination', function(){
	 return function(input, start){
	  start = +start;
	  return input.slice(start);
	 };
});
