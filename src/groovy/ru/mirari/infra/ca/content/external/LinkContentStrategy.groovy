package ru.mirari.infra.ca.content.external

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.atom.CreativeAtomContentDTO

/**
 * @author alari
 * @since 9/2/12 1:37 AM
 */
@Component
class LinkContentStrategy extends ExternalContentStrategy {
    @Override
    void buildContentByUrl(CreativeAtom atom, URL url) {
        // TODO: load page, implement vk-like logic to handle data
    }

    @Override
    boolean isUrlSupported(URL url) {
        // TODO: check if it returns 200
        return false
    }

    @Override
    CreativeAtomContentDTO getContentDTO(CreativeAtom atom) {
        CreativeAtomContentDTO dto = super.getContentDTO(atom)
        dto.externalId = getExternalId(atom)
        dto
    }
}
