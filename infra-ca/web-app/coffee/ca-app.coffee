exports = this

angular.module("ca.app", ['ca.CreativeAtom', 'ca.ui', 'ca.base'])


exports.CreativeAtomCtr = ($scope, CreativeAtom, caTemplates, caUrls)->
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

  $scope.delete = (atom)->
    $scope.atoms = $scope.atoms.filter (el)->el.id != atom.id
    atom.$delete id: atom.id

  $scope.tpls = caTemplates

  $scope.updateFile = (atom)->
    (o, e)->
      delete atom.class
      e.url = caUrls.restAtom(atom)
      e.formData = atom
      e.submit()

  $scope.updateFileDone = (atom)->
    (e, data)->
      $scope.$apply ->
        atom[k] = v for k,v in data.result if atom[k]
        (atom.sounds[k] = v+"?"+Math.random()) for k,v in data.result.sounds if data.result.sounds
        (atom.images[k] = v+"?"+Math.random()) for k,v in data.result.images if data.result.images
        atom.processUpdate = false