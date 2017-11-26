'use strict';

angular.module('transcript.filter.taxonomyEntityNameConstruct', ['ui.router'])

    .filter('taxonomyEntityNameConstruct', [function() {
        return function (entity, type) {
            let entityName = "";
            switch(type) {
                case "testators":
                    entityName = entity.surname+", "+entity.firstnames;
                    break;
                case "places":
                    entityName = entity.name;
                    break;
                case "military-units":
                    entityName = entity.name;
                    break;
                default:
                    entityName = "Inconnu";
            }
            return entityName;
        }
    }])

;