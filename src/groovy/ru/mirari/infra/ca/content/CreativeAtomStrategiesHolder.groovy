package ru.mirari.infra.ca.content

import org.springframework.stereotype.Component
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationContext

/**
 * @author alari
 * @since 9/23/12 12:29 PM
 */
@Component
class CreativeAtomStrategiesHolder implements ApplicationContextAware {
    static private Map<String,CreativeAtomStrategy> strategies

    Map<String,CreativeAtomStrategy> getStrategies() {
        strategies
    }

    static CreativeAtomStrategy byName(final String name) {
        strategies.get(name)
    }

    @Override
    void setApplicationContext(ApplicationContext applicationContext) {
        strategies = [:]
        applicationContext.getBeansOfType(CreativeAtomStrategy).entrySet().each {
            strategies.put(it.key - "ContentStrategy", it.value)
        }
    }
}
