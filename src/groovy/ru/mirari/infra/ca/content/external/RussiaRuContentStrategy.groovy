package ru.mirari.infra.ca.content.external

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO

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

    @Override
    CreativeAtomContentDTO getContentDTO(CreativeAtom atom, CreativeAtomContentDTO dto = null) {
        dto = super.getContentDTO(atom, dto)
        dto.externalId = getExternalId(atom)
        dto
    }
}
