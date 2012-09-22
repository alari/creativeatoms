modules = {
    'ca-core' {
        resource url:'coffee/CreativeAtom.coffee'
        dependsOn "angular", "angular-ui", 'jquery-file-upload', 'mediaelementplayer'
    }

    'angular-ui'{
        resource url:'vendor/angular-ui/angular-ui.min.js'
        resource url:'vendor/angular-ui/angular-ui.min.css'
        resource url:'vendor/angular-ui/angular-ui-ieshiv.min.js'
        dependsOn "angular"
    }

    'jquery-file-upload'{
        resource url: "vendor/blueimp-jQuery-File-Upload/js/jquery.iframe-transport.js"
        resource url: "vendor/blueimp-jQuery-File-Upload/js/vendor/jquery.ui.widget.js"
        resource url: "vendor/blueimp-jQuery-File-Upload/js/jquery.fileupload.js"
        dependsOn "jquery"
    }

    'mediaelementplayer'{
        resource url: "vendor/mediaelement/mediaelement-and-player.min.js"
        resource url: "vendor/mediaelement/mediaelementplayer.min.css"
        dependsOn "jquery"
    }
}