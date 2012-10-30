package ru.mirari.infra.ca.strategy

import org.apache.commons.lang.RandomStringUtils
import ru.mirari.infra.ca.Atom
import ru.mirari.infra.file.FileInfo

/**
 * @author alari
 * @since 10/28/12 12:30 AM
 */
abstract class AtomStrategy {
    void setContentFile(Atom atom, FileInfo fileInfo) {}

    boolean isEmpty(Atom atom) {false}

    boolean isContentFileSupported(FileInfo type) {false}

    abstract boolean isExternal()

    abstract void buildContentByUrl(Atom atom, URL url);

    abstract boolean isUrlSupported(URL url);

    private volatile String name

    String getName() {
        if (name == null) {
            synchronized (this) {
                if (name == null) {
                    name = this.class.simpleName - "Strategy"
                    name = name[0].toLowerCase() + name.substring(1)
                }
            }
        }
        name
    }

    void deleteContent(Atom atom) {
        void
    }

    boolean setContent(Atom atom, Atom.Push dto) {
        if (dto.externalUrl && isExternal()) {
            // By external url
            try {
                URL url = new URL(dto.externalUrl)
                if (isUrlSupported(url)) {
                    atom.id = RandomStringUtils.randomAlphanumeric(16);
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
                atom.id = RandomStringUtils.randomAlphanumeric(16);
                setContentFile(atom, fileInfo)
                return true
            }
        }
        false
    }

    Atom getForRender(Atom atom) {atom}

    Atom getForUpdate(Atom atom) {atom}
}
