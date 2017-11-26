'use strict';

angular.module('transcript.filter.roleName', ['ui.router'])

    .filter('roleName', [function() {
        return function (role) {
            let roleName = "";
            switch(role) {
                case "ROLE_USER":
                    roleName = "utilisateur";
                    break;
                case "ROLE_TAXONOMY_EDIT":
                    roleName = "contributeur aux notices";
                    break;
                case "ROLE_MODO":
                    roleName = "modérateur";
                    break;
                case "ROLE_ADMIN":
                    roleName = "administrateur";
                    break;
                case "ROLE_SUPER_ADMIN":
                    roleName = "super administrateur";
                    break;
                default:
                    roleName = "inconnu";
            }
            return roleName;
        }
    }])

;