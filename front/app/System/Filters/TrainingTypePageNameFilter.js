'use strict';

angular.module('transcript.filter.trainingTypePageName', ['ui.router'])

    .filter('trainingTypePageName', [function() {
        return function (trainingTypePageId) {
            let trainingTypePageName = "";
            switch(trainingTypePageId) {
                case "exercise":
                    trainingTypePageName = "Page d'exercise";
                    break;
                case "presentation":
                    trainingTypePageName = "Page de présentation";
                    break;
                default:
                    trainingTypePageName = "Inconnu";
            }
            return trainingTypePageName;
        }
    }])

;