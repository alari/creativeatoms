package ru.mirari.infra.ca.atom.dto

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO

/**
 * @author alari
 * @since 9/2/12 1:50 AM
 */
class CreativeAtomContentBaseDTO implements CreativeAtomContentDTO {
    def id

    String title
    String type

    String text
    String externalId

    Map<String, String> sounds
    Map<String, String> images

    CreativeAtomContentBaseDTO() {}

    CreativeAtomContentBaseDTO(final CreativeAtom atom) {
        id = atom.atomId
        title = atom.title
        type = atom.strategy().name
    }
}
