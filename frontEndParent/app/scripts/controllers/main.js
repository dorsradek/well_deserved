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



  }]);
