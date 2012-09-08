package ru.mirari.infra.ca.atom

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO

/**
 * @author alari
 * @since 9/8/12 1:56 PM
 */
class CreativeAtomUpdateBaseDTO extends CreativeAtomContentBaseDTO implements CreativeAtomUpdateDTO {
    CreativeAtomUpdateBaseDTO(CreativeAtom atom) {
        super(atom)
    }

    String externalUrl
    File file
    String originalFilename
}
