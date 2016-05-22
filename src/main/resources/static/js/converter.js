'use strict';

angular.module('myApp', [])
  .controller('ArabicRomanConvertController', function($scope, $http) {

	$scope.arabic = "1";
	$scope.roman = "C";				

    $scope.$watch('arabic', function() {
		fetchArabic();
    });

    function fetchArabic() {
      $http.get("/services/enum/arabicToRoman/" + $scope.arabic)
        .then(function(response) {
          $scope.romanResult = response.data;
        });
    }

    $scope.$watch('roman', function() {
		fetchRoman();
    });

    function fetchRoman() {
      $http.get("/services/enum/romanToArabic/" + $scope.roman)
        .then(function(response) {
          $scope.arabicResult = response.data;
        });
    }			

  }

);