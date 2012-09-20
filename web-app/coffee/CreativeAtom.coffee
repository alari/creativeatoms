exports = this

angular.module("ca.ui", ['ui'])
  .directive "caSound", ->
    (scope, element, attrs)->
      element.attr "src", scope.$eval(attrs['caSound'])
      $(element).mediaelementplayer
        pluginPath: "/vendor/mediaelement/"
        src: scope.$eval("atom.sounds['mpeg']")
  .directive "caRussiaRu", ->
    (scope, element, attrs)->
      externalId = scope.$eval(attrs['russiaRu'])
      $(element).html("<embed name='playerblog#{externalId}'
                      src='http://www.russia.ru/player/main.swf?103'
          flashvars='name=#{externalId}&from=blog&blog=true' width='448' height='252'
          bgcolor='#000000' allowScriptAccess='always' allowFullScreen='true'></embed>")

angular.module("ca.CreativeAtom", ['ngResource'])
  .factory 'CreativeAtom', ($resource)->
     $resource '/rest/creativeAtom/:id'

angular.module("ca.app", ['ca.CreativeAtom', 'ca.ui'])

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

  $scope.update = (atom)->
    if(atom.processUpdate)
      delete atom.class
      atom.$save {id: atom.id}, atom, ->
        atom.processUpdate = false
    else
      atom.$get {id: atom.id, update: true}, ->
        atom.processUpdate = true


  $scope.atomTemplate = (atom)->
    '/html/atom/'+atom.type+'.html?15'

  $scope.atomUpdateTemplate = (atom)->
    '/html/atom/'+atom.type+'.update.html?1'