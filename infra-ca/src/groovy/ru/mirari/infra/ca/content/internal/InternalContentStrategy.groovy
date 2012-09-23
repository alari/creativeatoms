package ru.mirari.infra.ca.content.internal

import ru.mirari.infra.ca.face.CreativeAtom

import ru.mirari.infra.ca.content.CreativeAtomStrategy

/**
 * @author alari
 * @since 1/6/12 7:19 PM
 */
abstract class InternalContentStrategy extends CreativeAtomStrategy {
    @Override
    boolean isExternal() {
        false
    }

    @Override
    void buildContentByUrl(CreativeAtom atom, URL url) {
        void
    }

    @Override
    boolean isUrlSupported(URL url) {
        false
    }
}
