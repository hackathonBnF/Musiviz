'use strict';

angular.module('transcript.filter.imageRender', ['ui.router'])

    .filter('imageRender', ['$rootScope', function($rootScope) {
        return function (url) {
            if(/^http/.test(url)) {
                return url;
            } else {
                return $rootScope.api_web+'/uploads/'+url;
            }
        }
    }])

;