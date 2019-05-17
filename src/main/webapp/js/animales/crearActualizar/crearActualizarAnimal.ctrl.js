var animalModule = angular.module('animalModule');

animalModule.controller('caAnimalCtrl', ['$scope', '$http', '$state', function($scope, $http, $state){
      var id = $state.params.id;

      $scope.animal = {};

      if(id){
        $http.get('api/animal/'+id).then(function(response){
            $scope.animal = response.data;
        }, function(error){
            console.log(error);
        });
      }

      $scope.guardarAnimal = function(){
        if($scope.animal.idAnimal && $scope.animal.idZoo && $scope.animal.idTipoAnimal && $scope.animal.idAlimentacion && $scope.animal.idCuidador && $scope.animal.nombre && $scope.animal.nombreCientificoAnimal && $scope.animal.descripcionAnimal && $scope.animal.especieAnimal ){
            $http.post('api/animal', JSON.stringify($scope.animal)).then(function(response){
                $scope.animal = {};
                $state.go('animales');
            }, function(error){
                console.log(error);
            });
        }
      };

      $scope.actualizarAnimal = function(){
         if($scope.animal.idAnimal && $scope.animal.idZoo && $scope.animal.idTipoAnimal && $scope.animal.idAlimentacion && $scope.animal.idCuidador && $scope.animal.nombre && $scope.animal.nombreCientificoAnimal && $scope.animal.descripcionAnimal && $scope.animal.especieAnimal){
             $http.put('api/animal/'+id, JSON.stringify($scope.animal)).then(function(response){
                 $scope.animal = {};
                 $state.go('animales');
             }, function(error){
                console.log(error);
             });

         }
      }
}]);
