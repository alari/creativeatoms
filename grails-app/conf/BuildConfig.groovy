grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.plugin.location.'infra-file-storage' = "infra-file-storage"
grails.plugin.location.'infra-images' = "infra-images"
grails.plugin.location.'infra-ca' = "infra-ca"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
        excludes 'svn'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"

        // For pegdown markdown
        mavenRepo "http://scala-tools.org/repo-releases"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        compile "org.apache.httpcomponents:httpclient:4.2.1"

        compile 'org.pegdown:pegdown:latest.release'
        compile "org.jsoup:jsoup:latest.release"

        compile "com.fasterxml.jackson.core:jackson-databind:latest.release"
        compile "com.fasterxml.jackson.core:jackson-annotations:latest.release"
        compile "com.fasterxml.jackson.core:jackson-core:latest.release"

        // runtime 'mysql:mysql-connector-java:5.1.20'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:latest.integration"
        runtime ":resources:latest.integration"

        test ":spock:latest.integration"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:latest.integration"

        compile ":twitter-bootstrap:latest.integration"
        compile ":angularjs-resources:latest.integration"
        compile ":coffeescript-resources:latest.integration"

        compile ":less-resources:latest.integration"


        compile ":shiro:latest.integration"


        build ":tomcat:$grailsVersion"

        runtime ":database-migration:latest.integration"

        compile ':cache:latest.integration'
    }
}
