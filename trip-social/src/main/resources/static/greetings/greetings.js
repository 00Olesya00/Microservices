angular.module('app').controller('greetingsController', function ($scope, $http, $localStorage) {



        $scope.article = {};
        $scope.showAttractions = false;
        $scope.showAccommodation = false;

        $scope.toggleAttractions = function() {
        $scope.showAttractions = !$scope.showAttractions;
    }

        $scope.toggleAccommodation = function() {
        $scope.showAccommodation = !$scope.showAccommodation;
    }


});