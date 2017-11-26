'use strict';

angular.module('transcript.filter.classicDate', ['ui.router'])

    .filter('classicDate', [function() {
        return function (dateStr) {
            let date = new Date(dateStr);
            let monthNames = [ 'janvier', 'février', 'mars', 'avril', 'mai', 'juin',
                'juillet', 'août', 'septembre', 'octobre', 'novembre', 'décembre' ];

            return date.getDate() + " " + monthNames[date.getMonth()] + " " + date.getFullYear();
        }
    }])

;