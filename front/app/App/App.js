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
                }
            },
            url: ''
        })
    }])

    .controller('AppCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', '$transition$', function($rootScope, $scope, $http, $sce, $state, $transition$) {
        console.log($transition$);

        $(function () {
            $('[data-toggle="tooltip"]').tooltip();
            $('[data-toggle="popover"]').popover();
        })
    }])
;