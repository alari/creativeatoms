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