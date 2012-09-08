package ru.mirari.infra.ca.atom

import groovy.transform.ToString
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO

/**
 * @author alari
 * @since 9/2/12 1:50 AM
 */
@ToString
class CreativeAtomContentBaseDTO implements CreativeAtomContentDTO {
    def id

    String title
    String type

    String text
    String externalId

    Map<String, String> sounds
    Map<String, String> images

    CreativeAtomContentBaseDTO(final CreativeAtom atom) {
        id = atom.atomId
        title = atom.title
        type = atom.type.name
    }

    CreativeAtomContentBaseDTO(final Map params) {
        params?.each { k, v -> this[k] = v }
    }
}
