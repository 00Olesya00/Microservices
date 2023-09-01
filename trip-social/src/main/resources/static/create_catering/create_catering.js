angular.module('app').controller('createCateringController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/caterings';

    $scope.createCatering = function (){
        console.log($scope.newCatering);
        $http.post(contextPath + '/create_catering', $scope.newCatering)

        $scope. then(function successCallback(response) {
            alert('Общепит добавлен');
            $scope.loadCaterings();
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
    };
});

