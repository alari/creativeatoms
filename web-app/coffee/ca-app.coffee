exports = this

angular.module("ca.app", ['ca.CreativeAtom', 'ca.CreativeChain', 'ca.ui', 'ca.base'])
.config(['$routeProvider', '$locationProvider',($routeProvider, $locationProvider)->

  $routeProvider.when("/", {controller: "RootCtr", templateUrl: "/html/test.html"})
    .when("/atom/:atomId", {controller: "AtomCtr", templateUrl: "/html/test.html"})
    .otherwise({redirectTo:"/"})

  $locationProvider.hashPrefix('!')
  #$locationProvider.html5Mode(true)


  #root page basics
]).controller("RootCtr", ['$scope', '$rootScope', ($scope, $rootScope)->
  $rootScope.corePiles = [
      {title: "test"},
      {title: "other"}
  ]

  $scope.title = "test"
  $rootScope.title = "root test"

  #layout basics
]).controller("LayoutCtr", ['$scope', '$rootScope', 'caTemplates', ($scope, $rootScope, caTemplates)->
  $rootScope.corePiles = []
  $rootScope.steps = ["root"]
  $rootScope.relatedPiles = ["related"]
  $rootScope.relatedNav = ["test"]
  $rootScope.relatedSites = [{title:"mirari sites"}]

  $scope.tpls = caTemplates

  #new atom form handler
]).controller("NewAtomCtr", ['$scope', 'CreativeAtom', ($scope, CreativeAtom)->
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


  #single atom render controller
]).controller("AtomCtr", ['$scope', 'CreativeAtom', 'caUrls', '$rootScope', ($scope, CreativeAtom, caUrls, $rootScope)->
  $scope.update = (atom)->
    alert "update"
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
        (atom.sounds[k] = v+"?"+Math.random()) for k,v in data.result.sounds if data.result.sounds
        (atom.images[k] = v+"?"+Math.random()) for k,v in data.result.images if data.result.images
        atom.processUpdate = false

  #queried atoms controller
]).controller("AtomQueryCtr", ['$scope', 'CreativeAtom', ($scope, CreativeAtom)->
  $scope.atoms = CreativeAtom.query()
])