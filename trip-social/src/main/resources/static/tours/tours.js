angular.module('app').controller('toursController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/tours/';

    $scope.loadTours = function (pageIndex= 1){
        $http({
            url: contextPath ,
            method: 'get',
            params: {
                'p': pageIndex,
                name_part: $scope.filter ? $scope.filter.name_part : null,
                min_start_date: $scope.filter ? $scope.filter.min_start_date : null,
                max_start_date: $scope.filter ? $scope.filter.max_start_date : null,
            }
        }).then(function (response){
            $scope.toursPage = response.data;
            $scope.navList =$scope.generatePagesIndexes(1, $scope.toursPage.totalPages);
            console.log(response.data);
        });
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage +1; i++){
            arr.push(i)
        }
        return arr;
    }

    $scope.showInfoTour = function (tourId) {
        console.log('click');
        $http.get(contextPath + "details_tour/" + tourId)
            .then(function (response) {
                alert(response.data.name)
                // $scope.loadTours();
            });
    };
    $scope.deleteTourById = function (tourId) {
        console.log('click');
        $http.delete(contextPath + tourId)
            .then(function (response) {
                alert('Удалено безвозвратно');
                $scope.loadTours();

            });
    };

    $scope.loadTours();
});