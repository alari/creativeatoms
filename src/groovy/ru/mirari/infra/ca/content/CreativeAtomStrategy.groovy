package ru.mirari.infra.ca.content

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.file.FileInfo

/**
 * @author alari
 * @since 9/1/12 9:29 PM
 */
@Component
abstract class CreativeAtomStrategy {
    void setContentFile(CreativeAtom atom, FileInfo fileInfo){}

    boolean isEmpty(CreativeAtom atom) {false}

    boolean isContentFileSupported(FileInfo type) {false}

    abstract boolean isExternal()

    abstract void buildContentByUrl(CreativeAtom atom, URL url);

    abstract boolean isUrlSupported(URL url);

    void deleteContent(CreativeAtom atom) {
        void
    }
}
