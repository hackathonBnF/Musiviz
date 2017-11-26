'use strict';

angular.module('musivic.service.record', ['ui.router'])

    .service('RecordService', function($http, $rootScope) {
        return {
            getRecords: function() {
                return $http.get(
                    $rootScope.api+"/"
                ).then(function(response) {
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            },
            getRecord: function() {
                return $http.get(
                    $rootScope.api+"/"
                ).then(function(response) {
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            }
        };
    })

;