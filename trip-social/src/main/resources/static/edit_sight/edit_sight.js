angular.module('app').controller('editSightController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/sights';

    $scope.loadEditSight = function () {
        console.log('click');
        $http({
            url: contextPath +  "/edit_sight/"+ $routeParams.sightId,
            method: 'GET'
        }).then(function (response) {
            $scope.editSight = response.data;
        });
    }

    $scope.loadEditSight();

    $scope.updateSight = function (){
        console.log($scope.updateSight);
        $http.post(contextPath + '/edit_sight/' + $routeParams.sightId, $scope.editSight)
            .then(function(response) {
                    console.log("Данные  успешно обновлены");
                    alert('Данные изменены');
                },
                function successCallback(response) {
                    console.log("Ошибка при обновлении данных о достопримечательности")
                    alert(response.data.messages);
                });

    };
});