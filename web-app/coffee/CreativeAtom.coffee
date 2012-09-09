exports = this

angular.module("CreativeAtom", ['ngResource'])
  .factory 'CreativeAtom', ($resource)->
     $resource '/rest/creativeAtom/:id'

exports.CreativeAtomCtr = ($scope, CreativeAtom)->
  $scope.atoms = CreativeAtom.query()

  $scope.newAtom = new CreativeAtom()

  $scope.push = ->
    $scope.newAtom.$save ->
      $scope.atoms.unshift $scope.newAtom if $scope.newAtom.type
      $scope.newAtom = new CreativeAtom()