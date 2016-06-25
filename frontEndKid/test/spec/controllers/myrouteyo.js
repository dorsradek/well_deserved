'use strict';

describe('Controller: MyrouteyoCtrl', function () {

  // load the controller's module
  beforeEach(module('martaApp'));

  var MyrouteyoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MyrouteyoCtrl = $controller('MyrouteyoCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MyrouteyoCtrl.awesomeThings.length).toBe(3);
  });
});
