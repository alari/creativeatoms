package ru.mirari.infra.ca

import ru.mirari.infra.ca.face.CreativeAtomContentRepo
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.atom.CreativeAtomDTO
import ru.mirari.infra.ca.face.CreativeAtomContent
import ru.mirari.infra.ca.atom.CreativeAtomType
import ru.mirari.infra.ca.face.CreativeAtomRawContent
import ru.mirari.infra.ca.face.CreativeAtomRawContentRepo
import ru.mirari.infra.file.FileInfo

/**
 * @author alari
 * @since 9/1/12 9:22 PM
 */
class CreativeAtomsService<A extends CreativeAtom, C extends CreativeAtomContent, R extends CreativeAtomRawContent> {
    CreativeAtomRepo<A> creativeAtomRepo
    CreativeAtomContentRepo<C> creativeAtomContentRepo
    CreativeAtomRawContentRepo<R> creativeAtomRawContentRepo

    A create(CreativeAtomDTO dto) {
        A atom = creativeAtomRepo.create()

        if(dto.externalUrl) {
            // By external url
            try {
                URL url = new URL(dto.externalUrl)
                for (CreativeAtomType type in getAtomTypes()) {
                    if (type.strategy.isUrlSupported(url)) {
                        type.strategy.buildContentByUrl(atom, url)
                        atom.type = type
                        break
                    }
                }
            } catch(MalformedURLException e) {
            }
        }
        if(dto.file) {
            FileInfo fileInfo = new FileInfo(dto.file, dto.originalFilename)
            for (CreativeAtomType type in getAtomTypes()) {
                if(type.strategy.isContentFileSupported(fileInfo)) {
                    type.strategy.setContentFile(atom, fileInfo)
                    atom.type = type
                    break
                }
            }
        }
        if(dto.title) atom.title = dto.title

        atom
    }

    private CreativeAtomType[] getAtomTypes() {
        CreativeAtomType.values()
    }
}
