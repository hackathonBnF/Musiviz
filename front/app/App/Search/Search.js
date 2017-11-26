'use strict';

angular.module('musiviz.search', ['ui.router'])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('musiviz.search', {
            views: {
                "page" : {
                    templateUrl: 'App/Search/Search.html',
                    controller: 'AppSearchCtrl'
                }
            },
            url: '/search/:searchQuery',
            resolve: {
                records: function(RecordService) {
                    return RecordService.getRecords();
                }
            }
        })
    }])

    .controller('AppSearchCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', 'records', '$transition$', 'RecordService', function($rootScope, $scope, $http, $sce, $state, records, $transition$, RecordService) {
        $rootScope.searchQuery = $transition$.params().searchQuery;
        $scope.records = records;
        $scope.displayThumbnailsValue = null;
        $scope.displayThumbnailsList = [];

        $scope.displayThumbnails = function(value) {
            console.log(value);
            if(value === null) {
                $scope.displayThumbnailsValue = null;
            } else {
                $http.get($rootScope.api+"image/getByAudioRecord/"+value
                ).then(function (response) {
                    console.log(response.data);
                    $scope.displayThumbnailsValue = value;
                    $scope.displayThumbnailsList = response.data;
                    console.log($scope.displayThumbnailsList);
                });
            }
        };

        $scope.faResources = function(value) {
            if (value < 5) {
                return "fa-1x";
            } else if (value >= 5 && value < 30) {
                return "fa-2x";
            } else if (value >= 30 && value < 75) {
                return "fa-2x";
            } else if (value >= 75) {
                return "fa-3x";
            }
        };

        $scope.faNoise = function(value) {
            if (value < 80) {
                return "fa-battery-0";
            } else if (value >= 60 && value < 80) {
                return "fa-battery-1";
            } else if (value >= 40 && value < 60) {
                return "fa-battery-2";
            } else if (value >= 20 && value < 40) {
                return "fa-battery-3";
            } else if (value >= 20) {
                return "fa-battery-4";
            }
        };

        $scope.colorNoise = function(value) {
            if (value < 80) {
                return "text-danger";
            } else if (value >= 60 && value < 80) {
                return "text-warning";
            } else if (value >= 40 && value < 60) {
                return "text-warning";
            } else if (value >= 20 && value < 40) {
                return "text-primary";
            } else if (value >= 20) {
                return "text-primary";
            }
        };
    }])
;