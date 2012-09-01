package ru.mirari.infra.ca.content

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.atom.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.file.FileInfo
import ru.mirari.infra.ca.atom.CreativeAtomContentDTO

/**
 * @author alari
 * @since 9/1/12 9:29 PM
 */
@Component
abstract class CreativeAtomStrategy {
    void setContentFile(CreativeAtom atom, FileInfo fileInfo) {}

    boolean isEmpty(CreativeAtom atom) {false}

    boolean isContentFileSupported(FileInfo type) {false}

    abstract boolean isExternal()

    abstract void buildContentByUrl(CreativeAtom atom, URL url);

    abstract boolean isUrlSupported(URL url);

    void deleteContent(CreativeAtom atom) {
        void
    }

    boolean setContent(CreativeAtom atom, CreativeAtomPushDTO dto) {
        if (dto.externalUrl) {
            // By external url
            try {
                URL url = new URL(dto.externalUrl)
                if (isUrlSupported(url)) {
                    buildContentByUrl(atom, url)
                    return true
                }
            }

            catch (MalformedURLException e) {
            }
        }
        if (dto.file) {
            FileInfo fileInfo = new FileInfo(dto.file, dto.originalFilename)
            if (isContentFileSupported(fileInfo)) {
                setContentFile(atom, fileInfo)
                return true
            }
        }
        false
    }

    CreativeAtomContentDTO getContentDTO(CreativeAtom atom) {
        new CreativeAtomContentDTO(atom)
    }
}
