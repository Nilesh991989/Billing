app.controller("billingController", ['$scope','$http','$rootScope','$location', function($scope,$http,$rootScope,$location) {
		$scope.items = [];
		$scope.selectedItems = [];
		$scope.newItem = {'discountRate': '0'};
		$scope.saveandprintflag = true;
		$scope.billingDate = new Date();
		$scope.pricewithoutvatanddiscount = 0;
		$scope.totalPriceWithvat = 0;		
		$scope.discountAmt = 0;
		$scope.totalvatamt = 0;
		$scope.calculateTotalflag = false;
		$scope.saveflag = true;
		$scope.discountedbill = true;
		
		
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
	    		value.freeItem = '0';
	    		value.discountRate = '0';	    		
	    	});
	    });
						
		$scope.saveandprint = function(){
			$scope.saveandprintflag = false;
			$scope.saveflag = false;
			$scope.addNew(); 	
			var billingdata = {
					  'name':$scope.merchantname,
					  'date':$scope.billingDate,					  
					  'selectedItems':$scope.selectedItems,
					  'finaldiscountamt': $scope.finaldiscountamtfinaldiscountamt,
					  'finalPrice':$scope.finalPrice
					  };			
	        $http.post('http://localhost:8080/api/save/bill', billingdata, config)
	          .success(function (data, status, headers, config) {
	               $scope.PostDataResponse = data;
	               $scope.billid = data.billid;
	        })
	        $scope.saveflag = false;			
		};
	    
	    $scope.addNew = function(){
	            $scope.selectedItems.push({ 
	                'name': $scope.newItem.name,
	                'mrp': $scope.newItem.mrp,
	                'price': $scope.newItem.price,	                
	                'quantity':$scope.newItem.quantity,
	                'discountRate': $scope.newItem.discountRate,
					'discountAmt':  ($scope.newItem.price * $scope.newItem.quantity * $scope.newItem.discountRate) / 100,
	                'pricewithvat': (($scope.newItem.price * $scope.newItem.quantity) - (($scope.newItem.price * $scope.newItem.quantity * $scope.newItem.discountRate) / 100))        
	            });
	            $scope.newItem = {'discountRate': '0'};
	    };	        
	    
	    $scope.calculateTotal = function(){
	    	$scope.finaldiscountamt = 0;
			$scope.finalPrice = 0;		
			$scope.finaldiscountamt = ($scope.newItem.price * $scope.newItem.quantity * $scope.newItem.discountRate) / 100;
			$scope.finalPrice = (($scope.newItem.price * $scope.newItem.quantity) - (($scope.newItem.price * $scope.newItem.quantity * $scope.newItem.discountRate) / 100));
	    	angular.forEach($scope.selectedItems,function(value){
	    		$scope.finaldiscountamt = $scope.finaldiscountamt + value.discountAmt;
	    		$scope.finalPrice = $scope.finalPrice + value.pricewithvat;
	    	});	    	
	    	$scope.calculateTotalflag = true;
	    	if($scope.finaldiscountamt > 0){
	    		$scope.discountedbill = true;
	    	}else{
	    		$scope.discountedbill = false;
	    	}
	    	$scope.saveandprint();
	    }
	}]);