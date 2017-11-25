'use strict';

angular.module('transcript.filter.transcriptionStatusName', ['ui.router'])

    .filter('transcriptionStatusName', [function() {
        return function (transcriptionStatusID) {
            let transcriptionStatusName = "";
            switch(transcriptionStatusID) {
                case "todo":
                    transcriptionStatusName = "à faire";
                    break;
                case "transcription":
                    transcriptionStatusName = "en cours";
                    break;
                case "validation":
                    transcriptionStatusName = "en validation";
                    break;
                case "validated":
                    transcriptionStatusName = "validé";
                    break;
                default:
                    transcriptionStatusName = "inconnu";
            }
            return transcriptionStatusName;
        }
    }])

;