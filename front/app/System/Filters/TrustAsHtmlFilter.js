'use strict';

angular.module('musiviz.filter.trustAsHtml', ['ui.router'])

    .filter('trustAsHtml', ['$sce', function($sce) {
        return function (value) {
            return $sce.trustAsHtml(value);
        }
    }])

;