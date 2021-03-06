var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
    	.when('/login',{
        templateUrl: '/views/login.html',
        controller: 'loginController'
    	})
        .when('/item',{
            templateUrl: '/views/item.html',
            controller: 'itemController'
        })
        .when('/billing',{
            templateUrl: '/views/billing.html',
            controller: 'billingController'
        })
        .when('/history',{
            templateUrl: '/views/history.html',
            controller: 'historyController'
        })
        .when('/billdetail',{
            templateUrl: '/views/billdetail.html',
            controller: 'billdetailController'
        })
        .otherwise(
            { redirectTo: '/login'}
        );
});