modules = {
    'ca-ui' {
        resource url: 'coffee/ca-ui.coffee'
        dependsOn "angular", "angular-ui", 'jquery-file-upload', 'mediaelementplayer', 'autoResize', 'ca-base'
    }
    'ca-CreativeAtom' {
        resource url: 'coffee/ca-CreativeAtom.coffee'
        dependsOn 'angular', 'ca-base'
    }
    'ca-CreativeChain' {
        resource url: 'coffee/ca-CreativeChain.coffee'
        dependsOn 'angular', 'ca-base'
    }
    'ca-app' {
        resource url:'coffee/ca-app.coffee'
        dependsOn 'ca-ui', 'ca-CreativeAtom', 'ca-CreativeChain', 'ca-base'
    }
    'ca-base' {
        resource url: 'coffee/ca-base.coffee'
        dependsOn 'angular'
    }

    /**
     * STYLE OVERRIDES
     */
    'custom-bootstrap' {
        dependsOn 'bootstrap'
        resource url:[dir: 'less', file: 'variables.less'], attrs:[rel: "stylesheet/less", type:'css']
    }

    /**
     * VENDORS RESOURCES
     */
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