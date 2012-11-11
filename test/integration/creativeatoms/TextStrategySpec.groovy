package creativeatoms

import grails.plugin.spock.IntegrationSpec

class TextStrategySpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "strategy is autowired"() {
        int i = 1
        expect:
        i = 1
    }
}