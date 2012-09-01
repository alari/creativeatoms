package ru.mirari.infra.ca.atom

import ru.mirari.infra.ca.face.CreativeAtom
import groovy.transform.ToString

/**
 * @author alari
 * @since 9/2/12 1:50 AM
 */
@ToString
class CreativeAtomContentDTO {
    String title
    String type

    String text
    String externalId

    Map<String,String> sounds
    Map<String,String> images

    CreativeAtomContentDTO(final CreativeAtom atom) {
        title = atom.title
        type = atom.type.name
    }
}
