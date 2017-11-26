'use strict';

angular.module('transcript.filter.resourceTypeName', ['ui.router'])

    .filter('resourceTypeName', [function() {
        return function (resourceType) {
            let resourceTypeName = "";
            switch(resourceType) {
                case "page":
                    resourceTypeName = "page";
                    break;
                case "envelope":
                    resourceTypeName = "enveloppe";
                    break;
                case "envelop":
                    resourceTypeName = "enveloppe";
                    break;
                case "codicil":
                    resourceTypeName = "codicille";
                    break;
                default:
                    resourceTypeName = "Inconnu";
            }
            return resourceTypeName;
        }
    }])

;