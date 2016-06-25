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

    self.isAddWish =  false ;
    self.showAddWish = showAddWish;
    self.cancel =cancel;
    self.addNewWish =addNewWish;
    self.sendRequest =sendRequest;

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
          status: "ADDED",
          points: 0
       });
      var createWish = function () {
        $http({
          method: 'POST',
          url: 'http://192.168.8.105:8080/wishes/create',
          data: {
            name: self.newWish.name,
            description: self.newWish.description,
            points: self.newWish.points
          }
        });
      };

      createWish();
  };

    function sendRequest(wish) {
      wish.wishStatus = "WAITING TO BUY";

      var requestToBuy = function () {
        $http({
          method: 'POST',
          url: 'http://192.168.8.105:8080/wishes/request',
          data: wish
        });
      };

      requestToBuy();
    };





  }]);
