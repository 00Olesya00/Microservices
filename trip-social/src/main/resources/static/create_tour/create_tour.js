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

    $scope.createSight = function (){
        console.log($scope.newSight);
        $http.post('http://localhost:8192/trip-social/api/v1/sights/create_sight', $scope.newSight)

        $scope. then(function successCallback(response) {
            alert('Достопримечательность добавлена');
            $scope.loadSights();
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };



    $scope.createComfort = function (){
        console.log($scope.newComfort);
        $http.post('http://localhost:8192/trip-social/api/v1/comforts/create_comfort', $scope.newComfort)

        $scope. then(function successCallback(response) {
            alert('Жилье добавлено');
            $scope.loadComforts();
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };



    $scope.createCatering = function (){
        console.log($scope.newCatering);
        $http.post('http://localhost:8192/trip-social/api/v1/caterings/create_catering', $scope.newCatering)
        $scope. then(function successCallback(response) {
            alert('Общепит добавлен');
            $scope.loadCaterings();
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };

});