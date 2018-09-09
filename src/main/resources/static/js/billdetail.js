app.controller('billdetailController', ['$scope','$rootScope','$location',function ($scope,$rootScope,$location){
	$scope.discountedbill = false;
	if( $rootScope.selectedBillDetail.finaldiscountamt > 0){
		$scope.discountedbill = true;
	}
	$scope.data = $rootScope.selectedBillDetail;	
	if($rootScope.token === undefined){
		$location.path('/login');
	}	
}]);