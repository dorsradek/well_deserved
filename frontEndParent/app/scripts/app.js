'use strict';

/**
 * @ngdoc overview
 * @name frontEndParentApp
 * @description
 * # frontEndParentApp
 *
 * Main module of the application.
 */
angular
  .module('frontEndParentApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/wishes.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/kids', {
        templateUrl: 'views/kids.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })

      .when('/tasks', {
        templateUrl: 'views/tasks.html',
        controller: 'tasksCtrl',
        controllerAs: 'tasks'
      })

      .when('/wishes', {
        templateUrl: 'views/wishes.html',
        controller: 'wishesCtrl',
        controllerAs: 'wishes'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
  .factory('pointsService', function($rootScope, $http) {
    
    var pointsService = {};

    var getPoints = function () {
      $http({
        method: 'GET',
        url: 'http://localhost:8080/kids/points'
      }).then(function successCallback(response) {
        $rootScope.points = response.data;
      }, function errorCallback(response) {
        $rootScope.points = 0;
      })
    };

    getPoints();


  pointsService.prepForBroadcast = function() {
    this.broadcastItem();
  };

  pointsService.broadcastItem = function() {
    $rootScope.$broadcast('handleBroadcast');
  };



  return pointsService;
});
