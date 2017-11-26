'use strict';

angular.module('musiviz.service.record', ['ui.router'])

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
            getImages: function(id) {
                return $http.get(
                    $rootScope.api+"image/getByAudioRecord/"+id
                ).then(function(response) {
                    console.log(response);
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            },
            getCreators: function(id) {
                return $http.get(
                    $rootScope.api+"creator/getByAudioRecord/"+id
                ).then(function(response) {
                    console.log(response);
                    return response.data;
                }, function errorCallback(response) {
                    console.log(response);
                    return response;
                });
            },
            getGenres: function(id) {
                return $http.get(
                    $rootScope.api+"genre/getByAudioRecord/"+id
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