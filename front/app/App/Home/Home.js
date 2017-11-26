'use strict';

angular.module('musiviz.home', ['ui.router'])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('musiviz.home', {
            views: {
                "page" : {
                    templateUrl: 'App/Home/Home.html',
                    controller: 'AppHomeCtrl'
                }
            },
            url: '/'
        })
    }])

    .controller('AppHomeCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', function($rootScope, $scope, $http, $sce, $state) {

    }])
;