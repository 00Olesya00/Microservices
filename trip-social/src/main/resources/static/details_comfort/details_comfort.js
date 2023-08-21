   angular.module('app').controller('detailsComfortController', function ($scope, $http,$routeParams) {
        const contextPath = 'http://localhost:8192/trip-social/api/v1/comforts/';

        $scope.showDetailsComfort = function() {
            console.log('click1');
            $http.get(contextPath + "details_comfort/" + $routeParams.comfortId )
                .then(function (response) {
                  $scope.detailsComfort = response.data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        };

       $scope.showDetailsComfort();
       $scope.showDetailsComfort();

       $scope.deleteComfortById = function () {
           console.log('click');
           $http.delete(contextPath + $routeParams.comfortId)
               .then(function (response) {
                   alert('Удалено безвозвратно');
                   $scope.loadComforts();
                   $scope.detailsComfort= null;
               });
       };

});


