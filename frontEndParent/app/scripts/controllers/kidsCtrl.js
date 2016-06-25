'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('kidsCtrl', ['$rootScope', '$scope', function ($rootScope, $scope) {
    $rootScope.currentKid = $scope.currentKid;
  }]);
