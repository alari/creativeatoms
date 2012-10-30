package ru.mirari.infra.ca.face

import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO

/**
 * @author alari
 * @since 9/1/12 9:22 PM
 */
public interface CreativeAtomsService<A extends CreativeAtom, C extends CreativeAtomContent> {
    A create(CreativeAtomPushDTO dto)

    boolean update(CreativeAtom atom, CreativeAtomUpdateDTO dto)

    CreativeAtomPushDTO getPushDTO(Map params)

    CreativeAtomUpdateDTO getUpdateDTO(Map params)
}
