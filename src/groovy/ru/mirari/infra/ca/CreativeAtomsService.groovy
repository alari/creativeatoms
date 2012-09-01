package ru.mirari.infra.ca

import ru.mirari.infra.ca.face.CreativeAtomContentRepo
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.atom.CreativeAtomDTO
import ru.mirari.infra.ca.face.CreativeAtomContent
import ru.mirari.infra.ca.atom.CreativeAtomType

/**
 * @author alari
 * @since 9/1/12 9:22 PM
 */
class CreativeAtomsService<A extends CreativeAtom, C extends CreativeAtomContent> {
    CreativeAtomRepo<A> creativeAtomRepo
    CreativeAtomContentRepo<C> creativeAtomContentRepo

    A create(CreativeAtomDTO dto) {
        A atom = creativeAtomRepo.create()
        atom.title = dto.title

        if(dto.externalUrl) {
            // By external url
            try {
                URL url = new URL(dto.externalUrl)
                for (CreativeAtomType type in getAtomTypes()) {
                    if (type.strategy.isUrlSupported(url)) {
                        type.strategy.buildContentByUrl(atom, url)
                        atom.type = type
                        return atom
                    }
                }
            } catch(MalformedURLException e) {
            }
        }

        atom
    }

    private CreativeAtomType[] getAtomTypes() {
        CreativeAtomType.values()
    }
}
