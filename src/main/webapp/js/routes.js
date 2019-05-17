var app = angular.module("Zoologico");

//Configuracion de enrutamiento de la app
app.config(["$stateProvider","$urlRouterProvider", function ($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise('/');

    $stateProvider.state("animales",{
       url: '/animales',
       views:{
           animalView:{
               templateUrl: './animales/listar/animalesDiv.html',
               controller: 'animalCtrl'
           }
       }
    });

    $stateProvider.state("crearAnimal", {
       url: '/animales/crearAnimal',
       views: {
           animalView:{
               templateUrl: './animales/crearActualizar/crearActualizarAnimal.html',
               controller: 'caAnimalCtrl'
           }
       }
    });

    $stateProvider.state("actualizarAnimal", {
       url: '/animales/actualizarProducto/:id',
       views: {
           animalView:{
               templateUrl: './animales/crearActualizar/crearActualizarAnimal.html',
               controller: 'caAnimalCtrl',
               params: {
                   id: null
               }
           }
       }
    });
}]);
