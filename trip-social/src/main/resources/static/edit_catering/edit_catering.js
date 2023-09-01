angular.module('app').controller('editCateringController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/caterings';

    $scope.loadEditCatering = function () {
        console.log('click');
        $http({
            url: contextPath +  "/edit_catering/"+ $routeParams.cateringId,
            method: 'GET'
        }).then(function (response) {
            $scope.editCatering = response.data;
        });
    }

    $scope.loadEditCatering();

    $scope.updateCatering = function (){
        console.log($scope.updatCtering);
        $http.post(contextPath + '/edit_catering/' + $routeParams.cateringId, $scope.editCatering)
            .then(function(response) {
                    console.log("Данные  успешно обновлены");
                    alert('Данные успешно изменены');
                },
                function successCallback(response) {
                    console.log("Ошибка при обновлении данных ")
                    alert(response.data.messages);
                });

    };
});