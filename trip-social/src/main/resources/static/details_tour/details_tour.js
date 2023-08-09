   angular.module('app').controller('detailsTourController', function ($scope, $http,$routeParams) {
        const contextPath = 'http://localhost:8192/trip-social/api/v1/tours/';


        $scope.showDetailsTour = function($routeParams) {
            console.log('click1');
            $http.get(contextPath + "details_tour/" + $routeParams.id )
                .then(function (response) {

                        $scope.detailsTour = response.data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        };

       $scope.deleteTourById = function (tourId) {
           console.log('click');
           $http.delete(contextPath + tourId)
               .then(function (response) {
                   $scope.loadTours();
               });
       };
        $scope.showDetailsTour();

});