'use strict';

// Declare app level module which depends on views, and components
angular.module('musivizApp', [
    'ui.router',
    'ngRoute',
    'ngAnimate',
    'ngCookies',
    'musiviz',
    'musiviz.home',
    'musiviz.discover'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');
}]);
