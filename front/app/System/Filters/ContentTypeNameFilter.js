'use strict';

angular.module('transcript.filter.contentTypeName', ['ui.router'])

    .filter('contentTypeName', [function() {
        return function (contentStatusId) {
            let contentTypeName = "";
            switch(contentStatusId) {
                case "blogContent":
                    contentTypeName = "Article";
                    break;
                case "helpContent":
                    contentTypeName = "Page d'aide";
                    break;
                case "staticContent":
                    contentTypeName = "Page";
                    break;
                default:
                    contentTypeName = "Inconnu";
            }
            return contentTypeName;
        }
    }])

;