var lugarModule = angular.module('lugarModule');

lugarModule.controller('lugarCtrl',['$scope','$http','$state', function ($scope,$http,$state){
    $scope.lugares = new Array();
    console.log($scope.lugares);
    $http.get('api/lugar').then(function (response){
        console.log(response);
        $scope.lugares = response.data;
    },function (error){
        console.log(error);
    });
    
    $scope.eliminar=function (id){
        $http.delete('api/lugar'+id).then(function (response){
            $state.reload();
        },function (error){
            console.log(error);
        })
    }
}]);

