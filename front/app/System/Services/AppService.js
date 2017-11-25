'use strict';

angular.module('transcript.service.app', ['ui.router'])

    .service('AppService', function($http, $rootScope) {
        return {
            getPreference: function() {
                return $http.get(
                    $rootScope.api+"/app-preference"
                ).then(function(response) {
                    return response.data[0];
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            },
            patchPreference: function(id,data) {
                return $http.patch($rootScope.api+"/app-preference/"+id, data).
                then(function(response) {
                    return response;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            }
        };
    })

;