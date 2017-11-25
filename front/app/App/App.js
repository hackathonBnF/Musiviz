'use strict';

angular.module('musiviz', ['ui.router'])
    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('musiviz', {
            abstract: true,
            views: {
                "page" : {
                    template: '<div ui-view="page"></div>',
                    controller: 'AppCtrl'
                },
                "navbar" : {
                    templateUrl: 'System/Navbar/Navbar.html',
                    //controller: 'TranscriptCtrl'
                },
                "footer" : {
                    templateUrl: 'System/Footer/Footer.html',
                    //controller: 'TranscriptCtrl'
                }
            },
            url: ''
        })
    }])

    .controller('AppCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', function($rootScope, $scope, $http, $sce, $state) {

    }])
;