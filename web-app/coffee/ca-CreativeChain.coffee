angular.module("ca.CreativeChain", ["ngResource", "ca.base"])
  .factory 'CreativeChain', ($resource, caUrls)->
    $resource caUrls.restChainResource