'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('tasksCtrl', ['$scope', function ($scope) {

    var self = $scope;
    $scope.tasks = [
      {
        name: "Clean your room",
        status: "TO DO",
        points: 3
      },
      {
        name: "Do your homework",
        status: "TO DO",
        points: 8
      },
      {
        name: "Wash the car",
        status: "TO DO",
        points: 6
      },
      {
        name: "Make dishes",
        status: "TO DO",
        points: 4
      },
    ];

  }]);
