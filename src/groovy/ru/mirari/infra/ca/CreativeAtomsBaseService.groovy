package ru.mirari.infra.ca

import ru.mirari.infra.ca.atom.CreativeAtomBasicType
import ru.mirari.infra.ca.atom.dto.CreativeAtomPushBaseDTO
import ru.mirari.infra.ca.atom.dto.CreativeAtomUpdateBaseDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.ca.face.*
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author alari
 * @since 9/8/12 6:14 PM
 */
class CreativeAtomsBaseService<A extends CreativeAtom, C extends CreativeAtomContent, R extends CreativeAtomRawContent> implements CreativeAtomsService<A, C, R> {
    @Autowired
    CreativeAtomRepo<A> creativeAtomRepo
    @Autowired
    CreativeAtomContentRepo<C> creativeAtomContentRepo
    @Autowired
    CreativeAtomRawContentRepo<R> creativeAtomRawContentRepo

    @Override
    A create(CreativeAtomPushDTO dto) {
        A atom = creativeAtomRepo.create()

        for (CreativeAtomType type in atomTypes) {
            if (type.strategy.setContent(atom, dto)) {
                atom.type(type)
                break
            }
        }

        if (dto.text && !atom.type()) {
            CreativeAtomBasicType.TEXT.strategy.setContent(atom, dto)
        }
        if (dto.title) atom.title = dto.title

        atom
    }

    @Override
    boolean update(CreativeAtom atom, CreativeAtomUpdateDTO dto) {
        if (atom.atomId != dto.id) {
            return false
        }
        atom.type().strategy.setContent(atom, dto)
    }

    @Override
    CreativeAtomPushDTO getPushDTO(Map params) {
        new CreativeAtomPushBaseDTO(params)
    }

    @Override
    CreativeAtomUpdateDTO getUpdateDTO(Map params) {
        new CreativeAtomUpdateBaseDTO(params)
    }

    Collection<CreativeAtomType> getAtomTypes() {
        CreativeAtomBasicType.values()
    }
}
