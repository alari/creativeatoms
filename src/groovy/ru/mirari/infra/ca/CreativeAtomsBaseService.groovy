package ru.mirari.infra.ca

import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.ca.atom.dto.CreativeAtomPushBaseDTO
import ru.mirari.infra.ca.atom.dto.CreativeAtomUpdateBaseDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.ca.face.*
import ru.mirari.infra.ca.content.CreativeAtomStrategy
import ru.mirari.infra.ca.content.CreativeAtomStrategiesHolder

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

    @Autowired
    CreativeAtomStrategiesHolder creativeAtomStrategiesHolder

    @Override
    A create(CreativeAtomPushDTO dto) {
        A atom = creativeAtomRepo.create()

        for(CreativeAtomStrategy strategy in creativeAtomStrategiesHolder.strategies.values()) {
            if (strategy.setContent(atom, dto)) {
                atom.strategy(strategy)
                break
            }
        }
        if (dto.title) atom.title = dto.title

        if (!atom.strategy() || atom.strategy().isEmpty(atom)) {
            creativeAtomRepo.delete(atom)
            atom = null
        } else {
            creativeAtomRepo.save(atom)
        }

        atom
    }

    @Override
    boolean update(CreativeAtom atom, CreativeAtomUpdateDTO dto) {
        if (!atom.atomId.toString().equals(dto.id.toString())) {
            return false
        }
        if(atom.strategy().setContent(atom, dto) && !atom.strategy().isEmpty(atom)) {
            atom.title = dto.title
            return true
        } else if(atom.title != dto.title) {
            atom.title = dto.title
            return true
        }
        false
    }

    @Override
    CreativeAtomPushDTO getPushDTO(Map params) {
        new CreativeAtomPushBaseDTO(params)
    }

    @Override
    CreativeAtomUpdateDTO getUpdateDTO(Map params) {
        new CreativeAtomUpdateBaseDTO(params)
    }
}
