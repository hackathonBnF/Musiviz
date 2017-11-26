'use strict';

angular.module('musiviz.result', ['ui.router'])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('musiviz.result', {
            views: {
                "page" : {
                    templateUrl: 'App/Result/Result.html',
                    controller: 'AppResultCtrl'
                }
            },
            url: '/resultat/:id'
        })
    }])

    .controller('AppResultCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', function($rootScope, $scope, $http, $sce, $state) {

    }])
;