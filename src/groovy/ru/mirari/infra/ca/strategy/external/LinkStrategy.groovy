package ru.mirari.infra.ca.strategy.external

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.Atom

/**
 * @author alari
 * @since 9/2/12 1:37 AM
 */
@Component
class LinkStrategy extends ExternalStrategy {
    @Override
    void buildContentByUrl(Atom atom, URL url) {
        // TODO: load page, implement vk-like logic to handle data
    }

    @Override
    boolean isUrlSupported(URL url) {
        // TODO: check if it returns 200
        return false
    }
}
