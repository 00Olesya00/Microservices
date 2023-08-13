angular.module('app').controller('editTourController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/tours';


    // http://localhost:8192/trip-social/api/v1/tours/edit_tour/47

    $scope.loadEditTour = function (tourId) {
        console.log('click');
        $http({
            url: contextPath +  "/edit_tour/"+tourId,
            method: 'GET'
        }).then(function (response) {
            $scope.editTour = response.data;

        });
    }


    $scope.updateTour = function (tourId){
        console.log($scope.updateTour());
        $http.post(contextPath + '/edit_tour/' +tourId, $scope.updateTour())

        $scope. then(function successCallback(response) {
            alert('Путешествие создано');
            $scope.loadTours();
        }, function errorCallback(response) {
            alert(response.data.messages);
        });
        $scope.loadTours()
    };

});