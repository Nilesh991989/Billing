app.controller("itemController", ['$scope','$http','$rootScope','$location', function($scope,$http,$rootScope,$location) {
		$scope.items = [];
		$scope.successoperationFlag = false;
		$scope.failureoperationFlag = false;
		
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
	    });
		
		
		$scope.save = function(){	
	        $http.post('http://localhost:8080/api/add/item', $scope.items, config)
	          .success(function (data, status, headers, config) {
	               $scope.PostDataResponse = data;
	               if(status == 200){
	   	        	$scope.successoperationFlag = true;
	   	        	$scope.failureoperationFlag = false;
	   	        	$scope.operationalMessage = "Data Save successfully";
	   	        }else{
	   	        	$scope.successoperationFlag = false;
	   	        	$scope.failureoperationFlag = true;
	   	        	$scope.operationalMessage = "Error while saving data";
	   	        }
	        })     
	   };
	    
	    $scope.addNew = function(item){
	            $scope.items.push({ 
	                'name': '', 
	                'mrp':'',
	                'price': '',
	                'vat': '',
	            });
	            $scope.PD = {};
	            $scope.operationFlag = false;
	    };
	    
	    $scope.remove = function(){
	            var newDataList=[];
	            var deleteDataList=[];
	            $scope.selectedAll = false;
	            angular.forEach($scope.items, function(selected){
	                if(!selected.selected){
	                    newDataList.push(selected);
	                }else{
	                	deleteDataList.push(selected);
	                }
	            }); 
	            $scope.items = newDataList;
	            $scope.delItem =deleteDataList;
	            
	            $http.post('http://localhost:8080/api/delete/item', $scope.delItem, config)
		          .success(function (data, status, headers, config) {	        	  
		              if(status == 200){
		            	   $scope.successoperationFlag = true;	   
		            	   $scope.failureoperationFlag = false;
		            	   $scope.operationalMessage = "Data delete successfully";
		               }else{
		            	   $scope.successoperationFlag = false;
		            	   $scope.failureoperationFlag = true;
		            	   $scope.operationalMessage = "Error while deleting data";
		               }
		               
		        })
	            
	        };
	    
	        $scope.checkAll = function () {
	            if (!$scope.selectedAll) {
	                $scope.selectedAll = true;
	            } else {
	                $scope.selectedAll = false;
	            }
	            angular.forEach($scope.items, function (items) {
	                items.selected = $scope.selectedAll;
	            });
	        };    
	}]);