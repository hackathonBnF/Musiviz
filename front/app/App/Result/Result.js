'use strict';

angular.module('musiviz.result', ['ui.router'])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('musiviz.result', {
            views: {
                "page" : {
                    templateUrl: 'App/Result/Result.html',
                    controller: 'AppResultCtrl'
                }
            },
            url: '/resultat/:id',
            resolve: {
                record: function(RecordService, $transition$) {
                    return RecordService.getRecord($transition$.params().id);
                }
            }
        })
    }])

    .controller('AppResultCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', 'record', function($rootScope, $scope, $http, $sce, $state, record) {
        $scope.record = record;

        var wavesurfer = Object.create(WaveSurfer);
        $scope.wavesurfer = wavesurfer;
        wavesurfer.init({
            container: '#waveform',
            waveColor: 'violet',
            progressColor: 'purple',
            minPxPerSec: 20,
            scrollParent: true
        });
        wavesurfer.on('ready', function () {
            var spectrogram = Object.create(WaveSurfer.Spectrogram);

            spectrogram.init({
                wavesurfer: wavesurfer,
                container: "#wave-spectrogram"
            });
        });
        wavesurfer.load('web/audio/test.mp3');
        $scope.$watch('wavesurfer.isPlaying()', function() {
            console.log(wavesurfer.isPlaying());
            $scope.playStatus = wavesurfer.isPlaying();
        });
    }])
;