package ru.mirari.infra.ca.content.file

import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.file.FileInfo
import ru.mirari.infra.image.ImageFormat
import ru.mirari.infra.image.ImageHolder
import ru.mirari.infra.image.ImageStorageService
import ru.mirari.infra.ca.content.internal.InternalContentStrategy
import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomImageHolderProvider
import ru.mirari.infra.ca.face.CreativeAtomImageHolder

/**
 * @author alari
 * @since 1/6/12 6:30 PM
 */
@Component
class ImageContentStrategy extends InternalContentStrategy {
    @Autowired
    private ImageStorageService imageStorageService
    @Autowired
    private CreativeAtomImageHolderProvider creativeAtomImageHolderProvider

    private CreativeAtomImageHolder getImageHolder(CreativeAtom atom) {
        creativeAtomImageHolderProvider.getImageHolder(atom)
    }

    @Override
    void setContentFile(CreativeAtom unit, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;
        imageStorageService.format(getImageHolder(unit), fileInfo.file)
        unit.title = fileInfo.title
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        type.mediaType == "image"
    }

    @Override
    void deleteContent(CreativeAtom unit) {
        imageStorageService.delete(getImageHolder(unit))
    }
}
