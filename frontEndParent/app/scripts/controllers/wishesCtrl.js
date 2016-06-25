'use strict';

/**
 * @ngdoc function
 * @name frontEndParentApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontEndParentApp
 */
angular.module('frontEndParentApp')
  .controller('wishesCtrl', ['$scope', function ($scope) {
    $scope.points = 40; 
    var self = $scope;
    self.wishes = [
      {
        name: "New race car",
        description: "as seen here: http://allegro.pl/show_item.php?gclid=Cj0KEQjw17i7BRC7toz5g5DM0tsBEiQAIt7nLCexhXf1AHRUTq76ZlThDZNaN2o855BVwk_IW1rvEa4aAib38P8HAQ&item=5199076970&utm_source=google&utm_medium=cpc&ev_campaign=PLASmA-KidKraft",
        status: "PRICED",
        points: 30
      },
      {
        name: "IPOD",
        description: "as seen here: http://allegro.pl/show_item.php?gclid=Cj0KEQjw17i7BRC7toz5g5DM0tsBEiQAIt7nLCexhXf1AHRUTq76ZlThDZNaN2o855BVwk_IW1rvEa4aAib38P8HAQ&item=5199076970&utm_source=google&utm_medium=cpc&ev_campaign=PLASmA-KidKraft",
        status: "ADDED",
        points: 0
      },
      {
        name: "Candies",
        description: "as seen here: http://allegro.pl/show_item.php?gclid=Cj0KEQjw17i7BRC7toz5g5DM0tsBEiQAIt7nLCexhXf1AHRUTq76ZlThDZNaN2o855BVwk_IW1rvEa4aAib38P8HAQ&item=5199076970&utm_source=google&utm_medium=cpc&ev_campaign=PLASmA-KidKraft",
        status: "TO BUY",
        points: 3
      },
      {
        name: "Apple juice",
        description: "as seen here: http://allegro.pl/show_item.php?gclid=Cj0KEQjw17i7BRC7toz5g5DM0tsBEiQAIt7nLCexhXf1AHRUTq76ZlThDZNaN2o855BVwk_IW1rvEa4aAib38P8HAQ&item=5199076970&utm_source=google&utm_medium=cpc&ev_campaign=PLASmA-KidKraft",
        status: "BOUGHT",
        points: 1
      },
    ];

  }]);
