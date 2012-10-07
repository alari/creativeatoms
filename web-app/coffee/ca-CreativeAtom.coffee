m = angular.module("ca.CreativeAtom", ['ngResource', 'ca.base'])
#REST resource
m.factory 'CreativeAtom', ($resource, caUrls)->
  $resource caUrls.restResource

#single atom render controller
m.controller "AtomCtr", ['$scope', 'CreativeAtom', 'caUrls', '$rootScope', ($scope, CreativeAtom, caUrls, $rootScope)->
  $scope.update = (atom)->
    if(atom.processUpdate)
      delete atom.class
      atom.$save {id: atom.id}, atom, ->
        atom.processUpdate = false
    else
      atom.$get {id: atom.id, update: true}, ->
        atom.processUpdate = true

  $scope.delete = (atom)->
    atom.$delete id: atom.id

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
        (atom.sounds[k] = v + "?" + Math.random()) for k,v in data.result.sounds if data.result.sounds
        (atom.images[k] = v + "?" + Math.random()) for k,v in data.result.images if data.result.images
        atom.processUpdate = false
]

