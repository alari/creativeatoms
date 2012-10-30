package ru.mirari.infra.ca.strategy.external

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.Atom

/**
 * @author alari
 * @since 1/6/12 7:33 PM
 */
@Component
class RussiaRuStrategy extends ExternalStrategy {
    @Override
    void buildContentByUrl(Atom atom, URL url) {
        if (!isUrlSupported(url)) return;
        //http://russia.ru/video/diskurs_12854/
        // TODO: validate characters in external id!
        atom.externalId = url.path.substring(7, url.path.size() - 1)
    }

    @Override
    boolean isUrlSupported(URL url) {
        url.host in ["russia.ru", "tv.russia.ru", "www.russia.ru"]
    }
}
