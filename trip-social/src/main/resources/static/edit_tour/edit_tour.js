angular.module('app').controller('editTourController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/tours';

    // http://localhost:8192/trip-social/api/v1/tours/edit_tour/47

    $scope.loadEditTour = function () {
        console.log('click');
        $http({
            url: contextPath +  "/edit_tour/"+ $routeParams.tourId,
            method: 'GET'
        }).then(function (response) {
            $scope.editTour = response.data;
        });
    }

    $scope.loadEditTour();

    $scope.updateTour = function (){
        console.log($scope.updateTour);

        $http.post(contextPath + '/edit_tour/' + $routeParams.tourId, $scope.editTour)
            .then(function(response) {
                    // Обработка успешного обновления
                    console.log("Данные о путешествии успешно обновлены");
                    alert('Путешествие изменено');
                },
                function successCallback(response) {
                    // Обработка ошибок при обновлении
                    console.log("Ошибка при обновлении данных о путешествии")
                    alert(response.data.messages);
                });

    };
});