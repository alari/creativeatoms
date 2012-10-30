package ru.mirari.infra.ca.strategy

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * @author alari
 * @since 9/23/12 12:29 PM
 */
@Component
class AtomStrategiesHolder implements ApplicationContextAware {
    static private Map<String, AtomStrategy> strategies

    Map<String, AtomStrategy> getStrategies() {
        strategies
    }

    static AtomStrategy byName(final String name) {
        strategies.get(name)
    }

    @Override
    void setApplicationContext(ApplicationContext applicationContext) {
        strategies = [:]
        applicationContext.getBeansOfType(AtomStrategy).entrySet().each {
            strategies.put(it.key - "Strategy", it.value)
        }
    }
}
