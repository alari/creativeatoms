package ru.mirari.infra.ca.face

import ru.mirari.infra.ca.content.CreativeAtomStrategy

/**
 * @author alari
 * @since 9/8/12 11:03 PM
 */
public interface CreativeAtomType {
    String name()

    String getName()

    CreativeAtomStrategy getStrategy()
}