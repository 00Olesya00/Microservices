angular.module('app').controller('sightsController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/sights/';

    $scope.loadSights = function (pageIndex= 1){
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
            $scope.sightsPage = response.data;
            $scope.navList =$scope.generatePagesIndexes(1, $scope.sightsPage.totalPages);
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

    $scope.showInfoSight = function (sightId) {
        console.log('click');
        $http.get(contextPath + "details_sight/" + sightId)
            .then(function (response) {
                alert(response.data.name)

            });
    };

    $scope.deleteSightById = function (sightId) {
        console.log('click');
        $http.delete(contextPath + sightId)
            .then(function (response) {
                alert('Удалено безвозвратно');
                $scope.loadSights();
            });
    };

    $scope.loadSights();
    $scope.loadSights();

});