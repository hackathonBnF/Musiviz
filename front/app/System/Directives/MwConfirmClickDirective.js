'use strict';

angular.module('transcript.directive.mwConfirmClick', ['ui.router'])

    .directive( "mwConfirmClick", [
        function( ) {
            return {
                priority: -1,
                restrict: 'A',
                scope: { confirmFunction: "&mwConfirmClick" },
                link: function( scope, element, attrs ){
                    element.bind( 'click', function( e ){
                        // message defaults to "Are you sure?"
                        let message = attrs.mwConfirmClickMessage ? attrs.mwConfirmClickMessage : "Are you sure?";
                        // confirm() requires jQuery
                        if( confirm( message ) ) {
                            scope.confirmFunction();
                        }
                    });
                }
            }
        }
    ])

;