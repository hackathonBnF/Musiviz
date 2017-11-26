'use strict';

angular.module('musivic.filter.trustAsHtml', ['ui.router'])

    .filter('trustAsHtml', ['$sce', function($sce) {
        return function (value) {
            return $sce.trustAsHtml(value);
        }
    }])

;