modules = {
    application {
        resource url:'coffee/CreativeAtom.coffee'
        dependsOn "angular"
    }

    'angular-ui'{
        resource url:'js/angular-ui/angular-ui.min.js'
        resource url:'js/angular-ui/angular-ui.min.css'
        resource url:'js/angular-ui/angular-ui-ieshiv.min.js'
        dependsOn "angular"
    }
}