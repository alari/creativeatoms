package ru.mirari.infra.ca.content.external

import ru.mirari.infra.ca.face.CreativeAtom
import org.springframework.stereotype.Component

/**
 * @author alari
 * @since 1/6/12 7:33 PM
 */
@Component
class RussiaRuContentStrategy extends ExternalContentStrategy {
    @Override
    void buildContentByUrl(CreativeAtom atom, URL url) {
        if (!isUrlSupported(url)) return;
        //http://russia.ru/video/diskurs_12854/
        // TODO: validate characters in external id!
        setExternalId(atom, url.path.substring(7, url.path.size() - 1))
    }

    @Override
    boolean isUrlSupported(URL url) {
        url.host in ["russia.ru", "tv.russia.ru", "www.russia.ru"]
    }
}
