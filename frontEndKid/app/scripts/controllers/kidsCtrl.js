'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('kidsCtrl', ['$scope', '$rootScope', function ($scope, $rootScope){
    $rootScope.currentKid = $scope.currentKid;
  }]);
