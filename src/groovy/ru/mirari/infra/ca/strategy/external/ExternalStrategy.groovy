package ru.mirari.infra.ca.strategy.external

import ru.mirari.infra.ca.strategy.AtomStrategy

/**
 * @author alari
 * @since 9/1/12 9:41 PM
 */
abstract class ExternalStrategy extends AtomStrategy {
    @Override
    boolean isExternal() {
        true
    }
}

