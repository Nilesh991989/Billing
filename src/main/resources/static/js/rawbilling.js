app.controller("rawbillingController", ['$scope','$http','$rootScope','$location', function($scope,$http,$rootScope,$location) {
		$scope.items = [];
		$scope.selectedItems = [];
		$scope.newItem = {};
		$scope.saveandprintflag = true;
		$scope.billingDate = new Date();
		$scope.totalPriceWithvat = 0;
		$scope.calculateTotalflag = false;
		$scope.saveflag = true;
		
		if($rootScope.token === undefined){
			$location.path('/login');
		}
		
		var config = {
                headers : {'Content-Type': 'application/json',
                	       'Authorization': 'Bearer ' + $rootScope.token }
        }
	
		$http.get("http://localhost:8080/api/items",config)
	    .then(function(response) {
	    	$scope.items = response.data;
	    	angular.forEach($scope.items,function(value){
	    		value.quantity = '0';
	    		value.newprice = '0';
	    	});
	    });
	    
	    $scope.addNew = function(){
	            $scope.selectedItems.push({ 
	                'name': $scope.newItem.name,
	                'mrp': $scope.newItem.mrp,
	                'price': $scope.newItem.newprice,	                
	                'quantity':$scope.newItem.quantity,	        
	                'pricewithvat': $scope.newItem.newprice * $scope.newItem.quantity	                
	            });
	            $scope.newItem = {'newprice' : '0'};
	    };	        
	    
	    $scope.calculateTotal = function(){	
	    	angular.forEach($scope.selectedItems,function(value){
	    		$scope.totalPriceWithvat = $scope.totalPriceWithvat + value.pricewithvat;
	    	});	    	
	    	$scope.totalPriceWithvat = $scope.totalPriceWithvat + ($scope.newItem.newprice * $scope.newItem.quantity);	    	
	    	$scope.calculateTotalflag = true;
	    	$scope.saveandprint();
	    }
	    
	    $scope.saveandprint = function(){
			$scope.saveandprintflag = false;
			$scope.saveflag = false;
			$scope.addNew(); 	
			var billingdata = {
					  'name':$scope.merchantname,
					  'date':$scope.billingDate,					  
					  'selectedItems':$scope.selectedItems,					  
					  'pricewithvat':$scope.totalPriceWithvat
					  };
			
	        $http.post('http://localhost:8080/api/save/rawbill', billingdata, config)
	          .success(function (data, status, headers, config) {
	               $scope.PostDataResponse = data;
	               $scope.billid = data.billid;
	        })
	        $scope.saveflag = false;			
		};
	}]);