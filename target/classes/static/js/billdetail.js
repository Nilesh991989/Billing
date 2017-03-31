app.controller('billdetailController', ['$scope','$rootScope','$location',function ($scope,$rootScope,$location){
	$scope.data = $rootScope.selectedBillDetail;
	
	if($rootScope.token === undefined){
		$location.path('/login');
	}	
}]);