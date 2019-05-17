var bodyModule = angular.module('bodyModule');

bodyModule.controller('bodyCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $http.get('/').then(function(response){
            
        }, function(error){
           
        });
    }]);
