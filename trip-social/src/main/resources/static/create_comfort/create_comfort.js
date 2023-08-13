angular.module('app').controller('createComfortController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/comforts';

    // http://localhost:8192/trip-social/api/v1/tours/create_comfort

    $scope.createComfort = function (){
        console.log($scope.newComfort);
        $http.post(contextPath + '/create_comfort', $scope.newComfort)

        $scope. then(function successCallback(response) {
            alert('Жилье добавлено');
            $scope.loadComforts();
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };
});

