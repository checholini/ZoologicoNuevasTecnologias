var productoModule = angular.module('animalModule');

productoModule.controller('animalCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        $scope.animales = new Array();

        $http.get('api/animal').then(function(response){
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
