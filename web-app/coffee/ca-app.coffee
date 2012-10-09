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
  $scope.tpls = caTemplates
]

m.service "authService", ($http)->
  @isAuthenticated = false

  @checkAuth = (callback)->
    $http.get("/authApi/checkAuth").success (data)=>
      @isAuthenticated = data.isAuthenticated
      callback() if callback

  @register = (login, password)->
    $http.post("/authApi/register", {username: login, password: password}).success (data)->
      console.log data

  @signOut = (callback)->
    $http.post("/authApi/signOut").success (data)=>
      @isAuthenticated = false
      callback() if callback

  @signIn = (data, callback)->
    $http.post("/authApi/signIn", {username: data.username, password: data.password, rememberMe: data.rememberMe}).success (r)=>
      @isAuthenticated = r.isAuthenticated
      callback(r) if callback


m.controller "AuthCtr", ['$scope', '$rootScope', 'authService', ($scope, $rootScope, authService)->
  $scope.isAuthenticated = false

  authService.checkAuth ->
    $scope.isAuthenticated = authService.isAuthenticated

  $scope.signOut = ->
    authService.signOut ->
      $scope.isAuthenticated = false
]

m.controller "RegisterCtr", ['$scope', 'authService', ($scope, authService)->
  $scope.register = ->
    authService.register($scope.username, $scope.password)
]

m.controller "SignInCtr", ['$scope', 'authService', ($scope, authService)->
  $scope.signIn = ->
    authService.signIn $scope, (data)->
      console.log data
]