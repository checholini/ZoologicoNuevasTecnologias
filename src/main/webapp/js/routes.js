var app = angular.module("Zoologico");

//Configuracion de enrutamiento de la app
app.config(["$stateProvider","$urlRouterProvider", function ($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise('/');

    $stateProvider.state("body",{
        url: '/',
        views:{
            bodyView:{
                templateUrl: './js/body/body.html',
                controller: 'bodyCtrl'
            }
        }
    })

    $stateProvider.state("animales",{
       url: '/animales',
       views:{
           bodyView:{
               templateUrl: './js/animales/listar/animalesDiv.html',
               controller: 'animalCtrl'
           }
       }
    });

    $stateProvider.state("crearAnimal", {
       url: '/animales/crearAnimal',
       views: {
           bodyView:{
               templateUrl: './js/animales/crearActualizar/crearActualizarAnimal.html',
               controller: 'caAnimalCtrl'
           }
       }
    });

    $stateProvider.state("actualizarAnimal", {
       url: '/animales/actualizarProducto/:id',
       views: {
           bodyView:{
               templateUrl: './js/animales/crearActualizar/crearActualizarAnimal.html',
               controller: 'caAnimalCtrl',
               params: {
                   id: null
               }
           }
       }
    });
}]);
