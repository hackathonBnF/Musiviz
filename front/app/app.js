'use strict';

// Declare app level module which depends on views, and components
angular.module('musivizApp', [
    'ui.router',
    'ngRoute',
    'ngAnimate',
    'ngCookies',
    'wavesurfer.angular',
    'musiviz',
    'musiviz.home',
    'musiviz.discover',
    'musiviz.result',
    'musiviz.search',
    'musiviz.service.record',
    'musiviz.filter.trustAsHtml',
    'musiviz.filter.seconds'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');
}]).run(['$rootScope', function($rootScope) {
    $rootScope.searchQuery = null;
    $rootScope.api = "http://tuba.hackathon.bnf.fr:8080/";
}]);
