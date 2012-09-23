angular.module("ca.CreativeAtom", ['ngResource', 'ca.base'])
  .factory 'CreativeAtom', ($resource, caUrls)->
    $resource caUrls.restResource