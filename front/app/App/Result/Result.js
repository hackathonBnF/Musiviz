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
                },
                images: function(RecordService, $transition$) {
                    return RecordService.getImages($transition$.params().id);
                },
                creators: function(RecordService, $transition$) {
                    return RecordService.getCreators($transition$.params().id);
                },
                genres: function(RecordService, $transition$) {
                    return RecordService.getGenres($transition$.params().id);
                }
            }
        })
    }])

    .controller('AppResultCtrl', ['$rootScope','$scope', '$http', '$sce', '$state', '$timeout', 'record', 'images', 'creators', 'genres', function($rootScope, $scope, $http, $sce, $state, $timeout, record, images, creators, genres) {
        $('.carousel').carousel({
            interval: 4000
        });

        $scope.record = record;
        $scope.creators = creators;
        $scope.genres = genres;
        $scope.mediaContainer = "";
        $scope.images = images.listImage;
        $scope.nbResult = images.count;
        $scope.arks = $scope.record.audioRecord.ark.split('/');
        $scope.audio = $scope.arks[$scope.arks.length-1];

        var wavesurfer = Object.create(WaveSurfer);
        $scope.wavesurfer = wavesurfer;
        wavesurfer.init({
            container: '#waveform',
            waveColor: '#3497db',
            progressColor: '#2980b9',
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
        wavesurfer.load('web/audio/'+$scope.audio+'.mp3');
        $scope.$watch('wavesurfer.isPlaying()', function() {
            console.log(wavesurfer.isPlaying());
            $scope.playStatus = wavesurfer.isPlaying();
        });
    }])
;