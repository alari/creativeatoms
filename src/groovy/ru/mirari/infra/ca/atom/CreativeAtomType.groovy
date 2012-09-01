package ru.mirari.infra.ca.atom

import ru.mirari.infra.ApplicationContextHolder
import ru.mirari.infra.ca.content.CreativeAtomStrategy

/**
 * @author alari
 * @since 9/1/12 9:30 PM
 */
public enum CreativeAtomType {
    YOUTUBE("youTube"),
    RUSSIARU("russiaRu"),

    TEXT("text"),
    IMAGE("image"),
    SOUND("sound");

    private static Map<String,CreativeAtomType> byName = [:]

    static {
        for (CreativeAtomType t in CreativeAtomType.values()) byName.put(t.name, t)
    }

    static CreativeAtomType byName(final String typeName) {
        if(!byName.containsKey(typeName)) throw new IllegalArgumentException("Unknown CA type ${typeName}")
        byName.get(typeName)
    }

    final public String name;
    transient private CreativeAtomStrategy strategy;

    private CreativeAtomType(String name) {
        this.name = name
    }

    String toString() {
        name
    }

    CreativeAtomStrategy getStrategy() {
        if(strategy == null) {
            synchronized (this) {
                if(!strategy) {
                    strategy = (CreativeAtomStrategy)ApplicationContextHolder.getBean("${name}ContentStrategy")
                }
            }
        }
        strategy
    }
}