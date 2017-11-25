'use strict';

angular.module('transcript.filter.status', ['ui.router'])

    .filter('status', [function() {
        return function (status) {
            let string = "";
            switch(status) {
                case "draft":
                    string = "brouillon";
                    break;
                case "public":
                    string = "public";
                    break;
                case "private":
                    string = "privé";
                    break;
                case "notIndexed":
                    string = "non indexé";
                    break;
                default:
                    string = "Inconnu";
            }
            return string;
        }
    }])

;