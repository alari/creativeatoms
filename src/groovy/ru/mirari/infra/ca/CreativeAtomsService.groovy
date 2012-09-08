package ru.mirari.infra.ca

import ru.mirari.infra.ca.atom.CreativeAtomPushBaseDTO
import ru.mirari.infra.ca.atom.CreativeAtomType
import ru.mirari.infra.ca.face.*

/**
 * @author alari
 * @since 9/1/12 9:22 PM
 */
class CreativeAtomsService<A extends CreativeAtom, C extends CreativeAtomContent, R extends CreativeAtomRawContent> {
    CreativeAtomRepo<A> creativeAtomRepo
    CreativeAtomContentRepo<C> creativeAtomContentRepo
    CreativeAtomRawContentRepo<R> creativeAtomRawContentRepo

    A create(CreativeAtomPushBaseDTO dto) {
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

    private CreativeAtomType[] getAtomTypes() {
        CreativeAtomType.values()
    }
}
