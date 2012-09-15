modules = {
    application {
        resource url:'coffee/CreativeAtom.coffee'
        dependsOn "angular", "angular-ui"
    }

    'angular-ui'{
        resource url:'js/angular-ui/angular-ui.min.js'
        resource url:'js/angular-ui/angular-ui.min.css'
        resource url:'js/angular-ui/angular-ui-ieshiv.min.js'
        dependsOn "angular"
    }

    'jquery-file-upload'{
        resource url: "js/blueimp-jQuery-File-Upload/js/jquery.iframe-transport.js"
        resource url: "js/blueimp-jQuery-File-Upload/js/vendor/jquery.ui.widget.js"
        resource url: "js/blueimp-jQuery-File-Upload/js/jquery.fileupload.js"
        dependsOn "jquery"
    }
}