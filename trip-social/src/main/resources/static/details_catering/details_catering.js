

   angular.module('app').controller('detailsCateringController', function ($scope, $http,$routeParams) {
        const contextPath = 'http://localhost:8192/trip-social/api/v1/caterings/';

        $scope.showDetailsCatering = function() {
            console.log('click1');
            $http.get(contextPath + "details_catering/" + $routeParams.cateringId )
                .then(function (response) {
                  $scope.detailsCatering = response.data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        };

       $scope.showDetailsCatering();

       $scope.deleteCateringById = function () {
           console.log('click');
           $http.delete(contextPath + $routeParams.cateringId)
               .then(function (response) {
                   alert('Удалено безвозвратно');
                   $scope.loadCaterings();
                   $scope.detailsCatering= null;
               });
       };
});


