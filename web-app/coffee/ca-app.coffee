exports = this

m = angular.module("ca.app", ['ca.CreativeAtom', 'ca.CreativeChain', 'ca.ui', 'ca.base'])
#root page basics
m.controller "RootCtr", ['$scope', '$rootScope', ($scope, $rootScope)->
  $rootScope.corePiles = [
    {title: "test"},
    {title: "other"}
  ]

  $scope.title = "test"
  $rootScope.title = "root test"


]

#layout basics
m.controller "LayoutCtr", ['$scope', '$rootScope', 'caTemplates', ($scope, $rootScope, caTemplates)->
  $rootScope.corePiles = []
  $rootScope.steps = ["root"]
  $rootScope.relatedPiles = ["related"]
  $rootScope.relatedNav = ["test"]
  $rootScope.relatedSites = [
    {title: "mirari sites"}
  ]

  $scope.tpls = caTemplates


]

#new atom form handler
m.controller "NewAtomCtr", ['$scope', 'CreativeAtom', ($scope, CreativeAtom)->
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
      $scope.atoms.unshift new CreativeAtom(data.result) if data.result.type
      $scope.newAtom = new CreativeAtom()


]

#queried atoms controller
m.controller("AtomQueryCtr", ['$scope', 'CreativeAtom', ($scope, CreativeAtom)->
  $scope.atoms = CreativeAtom.query()
])