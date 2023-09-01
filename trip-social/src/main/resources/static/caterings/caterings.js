

angular.module('app').controller('cateringsController', function ($scope, $http) {
    const contextPath = 'http://localhost:8192/trip-social/api/v1/caterings/';

    $scope.loadCaterings = function (pageIndex= 1){
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
            $scope.cateringsPage = response.data;
            $scope.navList =$scope.generatePagesIndexes(1, $scope.cateringsPage.totalPages);
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

    $scope.showInfoCatering = function (cateringId) {
        console.log('click');
        $http.get(contextPath + "details_catering/" + cateringId)
            .then(function (response) {
                alert(response.data.name)
                // $scope.loadTours();
            });
    };

    $scope.deleteCateringById = function (cateringId) {
        console.log('click');
        $http.delete(contextPath + cateringId)
            .then(function (response) {
                alert('Удалено безвозвратно');
                $scope.loadCaterings();

            });
    };

    $scope.loadCaterings();
    $scope.loadCaterings();
});