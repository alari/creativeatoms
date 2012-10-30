package ru.mirari.infra.ca.strategy.file

import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.FileStorageService
import ru.mirari.infra.ca.Atom
import ru.mirari.infra.ca.strategy.internal.InternalStrategy
import ru.mirari.infra.file.FileHolder

/**
 * @author alari
 * @since 1/6/12 5:53 PM
 */
abstract class FilesHolderStrategy extends InternalStrategy {
    @Autowired
    protected FileStorageService fileStorageService

    protected Holder getFileHolder(Atom atom) {
        new Holder(atom.id)
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
