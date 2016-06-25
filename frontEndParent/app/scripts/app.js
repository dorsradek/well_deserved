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
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
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
  });
