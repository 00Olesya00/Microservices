angular.module('app').controller('createSightController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/sights';

    // http://localhost:8192/trip-social/api/v1/tours/create_sight

    $scope.createSight = function (){
        console.log($scope.newSight);
        $http.post(contextPath + '/create_sight', $scope.newSight)

        $scope. then(function successCallback(response) {
            alert('Достопримечательность добавлена');
            $scope.loadSights();

        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };
});

