'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('wishesCtrl', ['$scope', '$rootScope', 'pointsService', '$http', function ($scope, $rootScope, pointsService, $http) {
    var self = $scope;


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
    
    self.isAddWish =  false ;
    self.showAddWish = showAddWish;
    self.cancel =cancel;
    self.addNewWish =addNewWish;

    self.newWish = {};


    var getWishes = function (){
      $http({
        method: 'GET',
        url: 'http://192.168.8.105:8080/wishes'

      }).then(function successCallback(response) {
        $scope.wishes = response.data;
      }, function errorCallback(response) {
        console.log("nothing")
      })};



    getWishes();


    $scope.addPoints = function(wish){
      wish.wishStatus="PRICED";
      $http({
        method: 'POST',
        url: 'http://192.168.8.105:8080/wishes/addPoints',
        data: wish

      })

  };

    function showAddWish() {
       self.isAddWish = true;
    };

    function cancel() {
      self.isAddWish = false;
    };


    function addNewWish() {
      self.isAddWish = false;
      self.wishes.push({
          name: self.newWish.name,
          description:  self.newWish.description,
          wishStatus: "ADDED",
          points: 0
       });
      self.newWish = {};
      
  };


    $scope.handleClick = function() {
      pointsService.prepForBroadcast();
    };

    $scope.$on('handleBroadcast', function() {
      $scope.points = pointsService.points;
      console.log($scope.points)
    });


  }]);
