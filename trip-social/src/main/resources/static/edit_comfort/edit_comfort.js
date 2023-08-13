angular.module('app').controller('editComfortController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/comforts';

    $scope.loadEditComfort = function () {
        console.log('click');
        $http({
            url: contextPath +  "/edit_comfort/"+ $routeParams.comfortId,
            method: 'GET'
        }).then(function (response) {
            $scope.editComfort = response.data;
        });
    }

    $scope.loadEditComfort();

    $scope.updateComfort = function (){
        console.log($scope.updateComfort);

        $http.post(contextPath + '/edit_comfort/' + $routeParams.comfortId, $scope.editComfort)
            .then(function(response) {
                    // Обработка успешного обновления
                    console.log("Данные о жилье успешно обновлены");
                    alert('Жилье изменено');
                },
                function successCallback(response) {
                    // Обработка ошибок при обновлении
                    console.log("Ошибка при обновлении данных о жилье")
                    alert(response.data.messages);
                });

    };
});