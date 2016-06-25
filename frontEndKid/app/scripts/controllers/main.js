'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('MainCtrl', ['$scope', '$rootScope', 'pointsService', '$http', function ($scope, $rootScope, pointsService, $http) {
    $rootScope.currentKid = 'Antek';


    $scope.points = '';

    var getPoints = function (){
      $http({
        method: 'GET',
        url: 'http://192.168.8.105:8080/kids/points'
      }).then(function successCallback(response) {
        $scope.points = response.data;
      }, function errorCallback() {
        console.log("nothing")
      })};
    

    getPoints();

  }]);
