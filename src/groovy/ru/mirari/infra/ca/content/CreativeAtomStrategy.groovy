package ru.mirari.infra.ca.content

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.dto.CreativeAtomContentBaseDTO
import ru.mirari.infra.ca.dto.CreativeAtomUpdateBaseDTO
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.file.FileInfo
import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.ca.face.CreativeAtomRepo

/**
 * @author alari
 * @since 9/1/12 9:29 PM
 */
@Component
abstract class CreativeAtomStrategy {
    @Autowired CreativeAtomRepo creativeAtomRepo

    void setContentFile(CreativeAtom atom, FileInfo fileInfo) {}

    boolean isEmpty(CreativeAtom atom) {false}

    boolean isContentFileSupported(FileInfo type) {false}

    abstract boolean isExternal()

    abstract void buildContentByUrl(CreativeAtom atom, URL url);

    abstract boolean isUrlSupported(URL url);

    private volatile String name

    String getName() {
        if(name == null) {
            synchronized (this) {
                if(name == null) {
                    name = this.class.simpleName - "ContentStrategy"
                    name = name[0].toLowerCase() + name.substring(1)
                }
            }
        }
        name
    }

    void deleteContent(CreativeAtom atom) {
        void
    }

    boolean setContent(CreativeAtom atom, CreativeAtomPushDTO dto) {
        if (dto.externalUrl && isExternal()) {
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
                creativeAtomRepo.save(atom)
                setContentFile(atom, fileInfo)
                return true
            }
        }
        false
    }

    CreativeAtomContentDTO getContentDTO(CreativeAtom atom, CreativeAtomContentDTO dto = null) {
        dto ?: new CreativeAtomContentBaseDTO(atom)
    }

    CreativeAtomUpdateDTO getUpdateDTO(CreativeAtom atom, CreativeAtomUpdateDTO dto = null) {
        if (!dto) dto = getBaseUpdateDTO(atom, dto)
        (CreativeAtomUpdateDTO) getContentDTO(atom, dto)
    }

    protected CreativeAtomUpdateDTO getBaseUpdateDTO(CreativeAtom atom, CreativeAtomUpdateDTO dto = null) {
        dto ?: new CreativeAtomUpdateBaseDTO(atom)
    }
}
