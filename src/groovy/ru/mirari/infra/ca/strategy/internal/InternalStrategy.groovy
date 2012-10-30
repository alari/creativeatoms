package ru.mirari.infra.ca.strategy.internal

import ru.mirari.infra.ca.Atom
import ru.mirari.infra.ca.strategy.AtomStrategy

/**
 * @author alari
 * @since 1/6/12 7:19 PM
 */
abstract class InternalStrategy extends AtomStrategy {
    @Override
    boolean isExternal() {
        false
    }

    @Override
    void buildContentByUrl(Atom atom, URL url) {
        void
    }

    @Override
    boolean isUrlSupported(URL url) {
        false
    }
}
