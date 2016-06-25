'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('tasksCtrl', ['$scope', '$rootScope', 'pointsService', '$http', function ($scope, $rootScope, pointsService, $http) {

    var self = $scope;
    self.getTasks = function (){
      $http({
        method: 'GET',
        url: 'http://192.168.8.105:8080/tasks'

      }).then(function successCallback(response) {
        $scope.tasks = response.data;
      }, function errorCallback(response) {
        console.log("nothing")
      })};

    self.getTasks();


    self.changeTaskToDone = function(task) {
      task.taskStatus = "DONE";

      var requestToBuy = function () {
        $http({
          method: 'POST',
          url: 'http://192.168.8.105:8080/tasks/done',
          data: task
        });
      };

      requestToBuy();
    };

  }]);
