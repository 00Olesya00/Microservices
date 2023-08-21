angular.module('app').controller('comfortsController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/comforts/';

    $scope.loadComforts = function (pageIndex= 1){
        $http({
            url: contextPath ,
            method: 'get',
            params: {
                'p': pageIndex,
                name_part: $scope.filter ? $scope.filter.name_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
            }
        }).then(function (response){
            $scope.comfortsPage = response.data;
            $scope.navList =$scope.generatePagesIndexes(1, $scope.comfortsPage.totalPages);
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


    $scope.deleteComfortById = function (comfortId) {
        console.log('click');
        $http.delete(contextPath + comfortId)
            .then(function (response) {
                $scope.loadComforts();
                alert('Удалено безвозвратно');
            });
    };

    $scope.showInfoComfort = function (comfortId) {
        console.log('click');
        $http.get(contextPath + "details_comfort/" + comfortId)
            .then(function (response) {
                alert(response.data.name)
                // $scope.loadTours();
            });
    };

    $scope.loadComforts();
    $scope.loadComforts();
});