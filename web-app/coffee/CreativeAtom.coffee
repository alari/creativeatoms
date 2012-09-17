exports = this

angular.module("CreativeAtom", ['ngResource','ui'])
  .factory 'CreativeAtom', ($resource)->
     $resource '/rest/creativeAtom/:id'
  .directive "bindAudio", ->
     (scope, element, attrs)->
       element.attr "src", scope.$eval("atom.sounds['mpeg']")
       console.log element
       $(element).mediaelementplayer
         pluginPath: "/vendor/mediaelement/"
         src: scope.$eval("atom.sounds['mpeg']")

exports.CreativeAtomCtr = ($scope, CreativeAtom)->
  $scope.atoms = CreativeAtom.query()

  $scope.newAtom = new CreativeAtom()

  $scope.push = ->
    $scope.newAtom.$save ->
      $scope.atoms.unshift $scope.newAtom if $scope.newAtom.type
      $scope.newAtom = new CreativeAtom()

  $scope.pushFile = (o, e)->
    e.formData = $scope.newAtom
    e.submit()

  $scope.fileDone = (e, data)->
    $scope.$apply ->
      $scope.atoms.unshift data.result if data.result.type
      $scope.newAtom = new CreativeAtom()