angular.module("ca.base", [])
  .service "caTemplates", ->
    @atom = "/html/atom/atom.html"
    @atomType = (atom)->
      '/html/atom/'+atom.type+'.html?19'
    @form = "/html/newAtom.html"
  .service "caUrls", ->
    @restResource = '/rest/creativeAtom/:id'
    @restAtom = (atom)->
      "/rest/creativeAtom/"+atom.id
    @mediaelementPluginPath = "/vendor/mediaelement/"