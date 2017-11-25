'use strict';

angular.module('transcript.filter.ucFirstStrict', ['ui.router'])

    .filter('ucFirstStrict', [function() {
        return function (string) {
            return string.charAt(0).toUpperCase() + string.slice(1);
        }
    }])

;