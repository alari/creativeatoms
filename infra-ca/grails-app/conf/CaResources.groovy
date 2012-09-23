modules = {
    'ca-ui' {
        resource url: [dir:'coffee',file:'ca-ui.coffee']
        dependsOn "angular", "angular-ui", 'jquery-file-upload', 'mediaelementplayer', 'autoResize', 'ca-base'
    }
    'ca-CreativeAtom' {
        resource url: [dir:'coffee',file:'ca-CreativeAtom.coffee']
        dependsOn 'angular', 'ca-base'
    }
    'ca-app' {
        resource url:[dir:'coffee',file:'ca-app.coffee']
        dependsOn 'ca-ui', 'ca-CreativeAtom', 'ca-base'
    }
    'ca-base' {
        resource url: [dir:'coffee',file:'ca-base.coffee']

        resource url: [dir: 'html', file: 'newAtom.html']

        dependsOn 'angular'
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

    'autoResize'{
        resource url: "vendor/autoResize/autoResize.js"
        dependsOn 'jquery'
    }
}