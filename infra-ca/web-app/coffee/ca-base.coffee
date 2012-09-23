angular.module("ca.base", [])
  .service "caTemplates", ->
    @atom = "/static/html/atom/atom.html"
    @atomType = (atom)->
      '/static/html/atom/'+atom.type+'.html?19'
    @form = "/static/html/newAtom.html"
  .service "caUrls", ->
    @restResource = '/rest/creativeAtom/:id'
    @restAtom = (atom)->
      "/rest/creativeAtom/"+atom.id
    @mediaelementPluginPath = "/vendor/mediaelement/"