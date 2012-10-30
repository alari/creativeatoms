package ru.mirari.infra.ca.strategy.file

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.mirari.infra.ca.Atom
import ru.mirari.infra.ca.face.CreativeAtomImageHolder
import ru.mirari.infra.ca.face.CreativeAtomImageHolderProvider
import ru.mirari.infra.ca.strategy.internal.InternalStrategy
import ru.mirari.infra.file.FileInfo
import ru.mirari.infra.image.ImageFormat
import ru.mirari.infra.image.ImageStorageService

/**
 * @author alari
 * @since 1/6/12 6:30 PM
 */
@Component
class ImageStrategy extends InternalStrategy {
    @Autowired
    private ImageStorageService imageStorageService
    @Autowired
    private CreativeAtomImageHolderProvider creativeAtomImageHolderProvider

    private CreativeAtomImageHolder getImageHolder(Atom atom) {
        creativeAtomImageHolderProvider.getImageHolder(atom)
    }

    @Override
    void setContentFile(Atom atom, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;
        imageStorageService.format(getImageHolder(atom), fileInfo.file)
        atom.title = fileInfo.title
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        type.mediaType == "image"
    }

    @Override
    void deleteContent(Atom unit) {
        imageStorageService.delete(getImageHolder(unit))
    }

    @Override
    Atom getForRender(Atom atom) {
        CreativeAtomImageHolder holder = getImageHolder(atom)
        holder.imageFormats.each {ImageFormat format ->
            atom.images.put(format.name, imageStorageService.getUrl(holder, format))
        }
        atom
    }
}
