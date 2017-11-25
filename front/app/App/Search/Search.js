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
            url: '/search'
        })
    }])

    .controller('AppSearchCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', function($rootScope, $scope, $http, $sce, $state) {

    }])
;