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


    $scope.points = '';

    var getPoints = function (){
      $http({
        method: 'GET',
        url: 'http://192.168.8.105:8080/kids/points'
      }).then(function successCallback(response) {
        $scope.points = response.data;
      }, function errorCallback(response) {
        console.log("nothing")
      })};



    getPoints();
    var self = $scope;



    self.isAddTask=  false ;
    self.showAddTask = showAddTask;
    self.cancel =cancel;
    self.addNewTask =addNewTask;
    self.verified =verified;
    $scope.tasks = [];

    var getTasks = function (){
      $http({
        method: 'GET',
        url: 'http://192.168.8.105:8080/tasks',

      }).then(function successCallback(response) {
        $scope.tasks = response.data;
      }, function errorCallback(response) {
        console.log("nothing")
      })};



    getTasks();



    function showAddTask() {
      self.isAddTask = true;
    };

    function cancel() {
      self.isAddTask = false;
    };


    function addNewTask() {
      self.isAddTask = false;
      self.tasks.push({
        name: self.newTask.name,
        taskStatus: "TO DO",
        points: self.newTask.points
      });

      var createTask = function (){
        $http({
          method: 'POST',
          url: 'http://192.168.8.105:8080/tasks/create',
          data: {
            name: self.newTask.name,
            points: self.newTask.points
          }
        }).then(function successCallback(response) {
          $scope.points = response.data;
        }, function errorCallback(response) {
          console.log("nothing")
        })};
      createTask();

    };

    function verified(task){
      task.taskStatus = "VERIFIED";
      $http({
        method: 'POST',
        url: 'http://192.168.8.105:8080/tasks/verify',
        data: task
      }).then (function success () {
        getPoints();
      })
      
    };

  }]);
