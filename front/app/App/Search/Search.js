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

    .controller('AppSearchCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', 'records', '$transition$', function($rootScope, $scope, $http, $sce, $state, records, $transition$) {
        $rootScope.searchQuery = $transition$.params().searchQuery;
        $scope.records = records;

        for(var iR in $scope.records) {
            var record = $scope.records[iR];

            record.noise = parseInt(Math.random()*100);

            record.associateResources = parseInt(Math.random()*100);

            record.bpm = parseInt(Math.random()*1000);
        }


        $scope.dotColor = function(value) {
            if (value < 25) {
                return "text-success";
            } else if (value >= 25 && value < 50) {
                return "text-info";
            } else if (value >= 50 && value < 75) {
                return "text-danger";
            } else if (value >= 75) {
                return "text-warning";
            }
        };

        $scope.dotSize = function(value) {
            if (value < 25) {
                return "fa-1x";
            } else if (value >= 25 && value < 50) {
                return "fa-2x";
            } else if (value >= 50 && value < 75) {
                return "fa-3x";
            } else if (value >= 75) {
                return "fa-4x";
            }
        };
    }])
;