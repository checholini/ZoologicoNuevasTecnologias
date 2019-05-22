var lugarModule = angular.module('lugarModule');

lugarModule.controller('caLugarCtrl',['$scope', '$http', '$state', function($scope, $http, $state){
      var id = $state.params.id;
      
      $scope.lugar = {};
      
      if(id){
          $http.get('api/lugar/'+id).then(function(response){
            $scope.animal = response.data;
        }, function(error){
            console.log(error);
        });
      }
      
      $scope.guardarLugar = function(){
        if($scope.lugar.idLugar && $scope.lugar.nomLugar && $scope.lugar.direccionLugar ){
            $http.post('api/lugar', JSON.stringify($scope.lugar)).then(function(response){
                $scope.lugar = {};
                $state.go('lugares');
            }, function(error){
                console.log(error);
            });
        }
      };

      $scope.actualizarLugar = function(){
         if($scope.lugar.idLugar && $scope.lugar.nomLugar && $scope.lugar.direccionLugar){
             $http.put('api/lugar/'+id, JSON.stringify($scope.lugar)).then(function(response){
                 $scope.lugar = {};
                 $state.go('lugares');
             }, function(error){
                console.log(error);
             });

         }
      }
}]);


