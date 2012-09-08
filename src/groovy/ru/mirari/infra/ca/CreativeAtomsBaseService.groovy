package ru.mirari.infra.ca

import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtomContentRepo
import ru.mirari.infra.ca.face.CreativeAtomRawContentRepo
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.atom.CreativeAtomType
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.ca.face.CreativeAtomContent
import ru.mirari.infra.ca.face.CreativeAtomRawContent
import ru.mirari.infra.ca.face.CreativeAtomsService

/**
 * @author alari
 * @since 9/8/12 6:14 PM
 */
class CreativeAtomsBaseService<A extends CreativeAtom, C extends CreativeAtomContent, R extends CreativeAtomRawContent> implements CreativeAtomsService<A, C, R> {
    CreativeAtomRepo<A> creativeAtomRepo
    CreativeAtomContentRepo<C> creativeAtomContentRepo
    CreativeAtomRawContentRepo<R> creativeAtomRawContentRepo

    A create(CreativeAtomPushDTO dto) {
        A atom = creativeAtomRepo.create()

        for (CreativeAtomType type in getAtomTypes()) {
            if (type.strategy.setContent(atom, dto)) {
                atom.type = type
                break
            }
        }

        if (dto.text && !atom.type) {
            CreativeAtomType.TEXT.strategy.setContent(atom, dto)
        }
        if (dto.title) atom.title = dto.title

        atom
    }

    boolean update(CreativeAtom atom, CreativeAtomUpdateDTO dto) {
        if(atom.atomId != dto.id) {
            return false
        }
        atom.type.strategy.setContent(atom, dto)
    }

    private CreativeAtomType[] getAtomTypes() {
        CreativeAtomType.values()
    }
}
