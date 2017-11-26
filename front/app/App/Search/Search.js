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
            url: '/search/:keywords',
            resolve: {
                records: function(RecordService) {
                    return RecordService.getRecords();
                }
            }
        })
    }])

    .controller('AppSearchCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', 'records', function($rootScope, $scope, $http, $sce, $state, records) {

    }])
;