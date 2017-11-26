'use strict';

angular.module('musivic.service.record', ['ui.router'])

    .service('RecordService', function($http, $rootScope) {
        return {
            getRecords: function() {
                return $http.get(
                    $rootScope.api+"audiorecord/all"
                ).then(function(response) {
                    console.log(response);
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            },
            getRecord: function(id) {
                return $http.get(
                    $rootScope.api+"audiorecord/get/"+id
                ).then(function(response) {
                    console.log(response);
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            },
            getByAudioRecord: function(id) {
                return $http.get(
                    $rootScope.api+"image/getByAudioRecord/"+id
                ).then(function(response) {
                    console.log(response);
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            }
        };
    })

;