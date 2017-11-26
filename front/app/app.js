'use strict';

// Declare app level module which depends on views, and components
angular.module('musivizApp', [
    'ui.router',
    'ngRoute',
    'ngAnimate',
    'ngCookies',
    'musiviz',
    'musiviz.home',
    'musiviz.discover',
    'musiviz.search',
    'musivic.service.record'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');
}]);
