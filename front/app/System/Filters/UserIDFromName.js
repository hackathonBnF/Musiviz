'use strict';

angular.module('transcript.filter.userIDFromName', ['ui.router'])

    .filter('userIDFromName', [function() {
        return function (name) {
            let id = '';
            let elements = name.split(' ');

            let surname = elements[elements.length-1];
            elements.splice(elements.length-1, 1);

            for(let iE in elements) {
                let detach = elements[iE].split('-');
                for(let i in detach) {
                    id += detach[i][0];
                }
            }

            id += surname.replace("-", "");

            return id;
        }
    }])

;