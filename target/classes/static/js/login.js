app.controller('loginController', ['$scope','$rootScope','$http','$location',function ($scope,$rootScope,$http,$location){
	$scope.errorFlag = false;
	
	$scope.login= function(){
		var userdata = {
				  'name':$scope.username,
				  'password':$scope.password
				  };			
	  var config = {
          headers : {'Content-Type': 'application/json'}
      };
	  
      $http.post('http://localhost:8080/user/login', userdata, config)
        .success(function (data, status, headers, config) {
        	    $rootScope.token = data.token;
            	$location.path('/billing');
            	$rootScope.loginFlag = true;})
        .error(function (data, status, headers, config) {
        	    $scope.errorFlag = true;
        		$scope.errormsg = data.message;        	   	
        })
	};
}]);