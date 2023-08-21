   angular.module('app').controller('detailsTourController', function ($scope, $http,$routeParams) {
        const contextPath = 'http://localhost:8192/trip-social/api/v1/tours/';


        $scope.showDetailsTour = function() {
            console.log('click1');
            $http.get(contextPath + "details_tour/" + $routeParams.tourId )
                .then(function (response) {

                        $scope.detailsTour = response.data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        };
        $scope.showDetailsTour();

});