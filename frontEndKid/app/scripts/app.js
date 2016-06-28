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

 


  pointsService.prepForBroadcast = function() {
    this.broadcastItem();
  };

  pointsService.broadcastItem = function() {
    $rootScope.$broadcast('handleBroadcast');
  };



  return pointsService;
});
