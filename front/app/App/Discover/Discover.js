'use strict';

angular.module('musiviz.discover', ['ui.router'])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('musiviz.discover', {
            views: {
                "page" : {
                    templateUrl: 'App/Discover/Discover.html',
                    controller: 'AppDiscoverCtrl'
                }
            },
            url: '/decouvrir'
        })
    }])

    .controller('AppDiscoverCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', function($rootScope, $scope, $http, $sce, $state) {

    }])
;