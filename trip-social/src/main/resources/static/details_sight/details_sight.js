   angular.module('app').controller('detailsSightController', function ($scope, $http,$routeParams) {
        const contextPath = 'http://localhost:8192/trip-social/api/v1/sights/';

        $scope.showDetailsSight = function() {
            console.log('click1');
            $http.get(contextPath + "details_sight/" + $routeParams.sightId )
                .then(function (response) {
                  $scope.detailsSight = response.data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        };

       $scope.showDetailsSight();
       $scope.showDetailsSight();

       $scope.deleteSightById = function () {
           console.log('click');
           $http.delete(contextPath + $routeParams.sightId)
               .then(function (response) {
                   alert('Удалено безвозвратно');
                   $scope.loadSights();
                   $scope.detailsSight= null;
               });
       };

});


