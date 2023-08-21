angular.module('app').controller('createTourController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/tours';

    // http://localhost:8192/trip-social/api/v1/tours/create_tour

    $scope.createTour = function (){
        console.log($scope.newTour);
        $http.post(contextPath + '/create_tour', $scope.newTour)

        $scope. then(function successCallback(response) {
            alert('Путешествие создано');
            $scope.loadTours();
            $scope.newTour= null;
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };

});