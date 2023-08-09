(function ($localStorage) {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'greetings/greetings.html',
                controller: 'greetingsController'
            })
            .when('/create_tour', {
                templateUrl: 'create_tour/create_tour.html',
                controller: 'createTourController'
            })
            .when('/details_tour/:tourId', {
                templateUrl: 'details_tour/details_tour.html',
                controller: 'detailsTourController'
            })
            .when('/tours', {
                templateUrl: 'tours/tours.html',
                controller: 'toursController'
            })
            .when('/about', {
                templateUrl: 'about/about.html',
                controller: 'aboutController'
            })
            .when('/edit_tour/:tourId', {
                templateUrl: 'edit_tour/edit_tour.html',
                controller: 'editTourController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        // const contextPath = 'http://localhost:8192/trip-social/api/v1';

    }
})();


angular.module('app').controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/';

    // http://localhost:8192/trip-social/index.html
    // http://localhost:8192/trip-social/api/v1/tours

});