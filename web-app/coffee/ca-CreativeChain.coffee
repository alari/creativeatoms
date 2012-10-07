m = angular.module("ca.CreativeChain", ["ngResource", "ca.base"])

m.factory 'CreativeChain', ($resource, caUrls)->
  $resource caUrls.restChainResource

# Single chain controller
m.controller 'ChainCtr', ($scope)->

  # Chains query controller
m.controller 'ChainQueryCtr', ($scope, CreativeChain)->
  $scope.chains = CreativeChain.query() || []

  $scope.createChain = ->
    chain = new CreativeChain()
    chain.$save ->
      chain.processUpdate = true
      chain.atoms ||= []
      $scope.chains.unshift chain

  $scope.update = (chain)->
    chain.processUpdate = !chain.processUpdate