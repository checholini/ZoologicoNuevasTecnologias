var animalModule = angular.module('animalModule');

animalModule.controller('animalCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        $scope.animales = new Array();
        console.log($scope.animales);
        $http.get('api/animal/').then(function(response){
            console.log(response);
            $scope.animales = response.data;
        }, function(error){
           console.log(error);
        });

        $scope.eliminar = function(id){
            $http.delete('api/animal/'+id).then(function(response){
                $state.reload();
            }, function(error){
               console.log(error);
            });
        }
    }]);
