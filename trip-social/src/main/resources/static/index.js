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
            .when('/create_comfort', {
                templateUrl: 'create_comfort/create_comfort.html',
                controller: 'createComfortController'
            })
            .when('/create_sight', {
                templateUrl: 'create_sight/create_sight.html',
                controller: 'createSightController'
            })
            .when('/create_catering', {
                templateUrl: 'create_catering/create_catering.html',
                controller: 'createCateringController'
            })
            .when('/details_tour/:tourId', {
                templateUrl: 'details_tour/details_tour.html',
                controller: 'detailsTourController'
            })
            .when('/details_comfort/:comfortId', {
                templateUrl: 'details_comfort/details_comfort.html',
                controller: 'detailsComfortController'
            })
            .when('/details_sight/:sightId', {
                templateUrl: 'details_sight/details_sight.html',
                controller: 'detailsSightController'
            })
            .when('/details_catering/:cateringId', {
                templateUrl: 'details_catering/details_catering.html',
                controller: 'detailsCateringController'
            })
            .when('/tours', {
                templateUrl: 'tours/tours.html',
                controller: 'toursController'
            })
            .when('/comforts', {
                templateUrl: 'comforts/comforts.html',
                controller: 'comfortsController'
            })
            .when('/sights', {
                templateUrl: 'sights/sights.html',
                controller: 'sightsController'
            })
            .when('/caterings', {
                templateUrl: 'caterings/caterings.html',
                controller: 'cateringsController'
            })
            .when('/edit_tour/:tourId', {
                templateUrl: 'edit_tour/edit_tour.html',
                controller: 'editTourController'
            })
            .when('/edit_sight/:sightId', {
                templateUrl: 'edit_sight/edit_sight.html',
                controller: 'editSightController'
            })
            .when('/edit_comfort/:comfortId', {
                templateUrl: 'edit_comfort/edit_comfort.html',
                controller: 'editComfortController'
            })
            .when('/edit_catering/:cateringId', {
                templateUrl: 'edit_catering/edit_catering.html',
                controller: 'editCateringController'
            })
            .when('/about', {
                templateUrl: 'about/about.html',
                controller: 'aboutController'
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

});