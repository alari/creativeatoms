package ru.mirari.infra.ca.atom

import ru.mirari.infra.ca.face.CreativeAtomType

import ru.mirari.infra.ca.content.CreativeAtomStrategy
import ru.mirari.infra.ApplicationContextHolder

/**
 * @author alari
 * @since 9/1/12 9:30 PM
 */
public enum CreativeAtomBasicType implements CreativeAtomType {
    YOU_TUBE,
    RUSSIA_RU,
    LINK,

    TEXT,
    IMAGE,
    SOUND;

    private static Map<String, CreativeAtomBasicType> byName = [:]

    static {
        for (CreativeAtomBasicType t in CreativeAtomBasicType.values()) byName.put(t.name(), t)
    }

    static CreativeAtomType byName(final String typeName) {
        byName.get(typeName)
    }

    transient private CreativeAtomStrategy strategy;

    String toString() {
        name()
    }

    String getName() {
        name()
    }

    CreativeAtomStrategy getStrategy() {
        if (strategy == null) {
            synchronized (this) {
                if (strategy == null) {
                    String strategyName = name().toLowerCase().tokenize("_")*.capitalize().join('')
                    strategyName = strategyName[0].toLowerCase() + strategyName.substring(1)
                    strategy = (CreativeAtomStrategy) ApplicationContextHolder.getBean("${strategyName}ContentStrategy")
                }
            }
        }
        strategy
    }
}