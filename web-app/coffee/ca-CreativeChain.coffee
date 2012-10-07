m = angular.module("ca.CreativeChain", ["ngResource", "ca.base"])

m.factory 'CreativeChain', ($resource, caUrls)->
  $resource caUrls.restChainResource

# Single chain controller
m.controller 'ChainCtr', ($scope)->

  # Chains query controller
m.controller 'ChainQueryCtr', ($scope)->