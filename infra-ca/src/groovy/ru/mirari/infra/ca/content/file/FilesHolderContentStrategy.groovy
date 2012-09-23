package ru.mirari.infra.ca.content.file

import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.FileStorageService

import ru.mirari.infra.file.FileHolder

import ru.mirari.infra.ca.content.internal.InternalContentStrategy
import ru.mirari.infra.ca.face.CreativeAtom

/**
 * @author alari
 * @since 1/6/12 5:53 PM
 */
abstract class FilesHolderContentStrategy extends InternalContentStrategy {
    @Autowired
    protected FileStorageService fileStorageService

    protected Holder getFileHolder(CreativeAtom atom) {
        new Holder(atom.atomId)
    }

    static public class Holder implements FileHolder {
        final public String atomId
        final public String filesPath

        List<String> fileNames = []
        String filesBucket = null

        Holder(Object unitId) {
            this.atomId = unitId.toString()
            this.filesPath = "f/".concat(unitId.toString())
        }

        String getFilesPath() {
            filesPath
        }
    }
}
