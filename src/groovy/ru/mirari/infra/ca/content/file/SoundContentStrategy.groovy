package ru.mirari.infra.ca.content.file

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.content.CreativeAtomData
import ru.mirari.infra.ca.content.CreativeAtomSoundType
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.file.FileHolder
import ru.mirari.infra.file.FileInfo
import ru.mirari.infra.ca.atom.CreativeAtomContentDTO

/**
 * @author alari
 * @since 1/6/12 5:59 PM
 */
@Component
class SoundContentStrategy extends FilesHolderContentStrategy {
    String filesBucket = "mirarisounds"

    @Override
    protected Holder getFileHolder(CreativeAtom unit) {
        Holder holder = super.getFileHolder(unit)
        holder.filesBucket = filesBucket
        holder
    }

    private Set<String> getSoundTypes(CreativeAtom unit) {
        CreativeAtomData.SOUND_TYPES.getSetFrom(unit)
    }

    private void setSoundTypes(CreativeAtom unit, Set<String> types) {
        CreativeAtomData.SOUND_TYPES.putTo(unit, types)
    }

    private List<String> getFileNames(CreativeAtom unit) {
        List<String> files = []
        for (String s : getSoundTypes(unit)) {
            files.add(CreativeAtomSoundType.forName(s).filename)
        }
        files
    }

    @Override
    void setContentFile(CreativeAtom unit, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;
        FileHolder holder = getFileHolder(unit)
        CreativeAtomSoundType soundType = CreativeAtomSoundType.forName(fileInfo.subType)

        fileStorageService.store(fileInfo.file, holder, soundType.filename)

        Set<String> currentTypes = getSoundTypes(unit) ?: []
        currentTypes.add(soundType.name)
        setSoundTypes(unit, currentTypes)

        unit.title = fileInfo.title
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        if (type.mediaType != "audio") return false;
        CreativeAtomSoundType.forName(type.subType) != null
    }

    @Override
    void deleteContent(CreativeAtom unit) {
        Holder holder = getFileHolder(unit)
        holder.fileNames = getFileNames(unit)
        fileStorageService.delete(holder)
        CreativeAtomData.SOUND_TYPES.putTo(unit, "")
    }

    @Override
    CreativeAtomContentDTO getContentDTO(CreativeAtom atom) {
        CreativeAtomContentDTO dto = super.getContentDTO(atom)

        dto.sounds = [:]

        FileHolder holder = getFileHolder(atom)
        for (String s: getSoundTypes(atom)) {
            dto.sounds.put(s, fileStorageService.getUrl(holder, CreativeAtomSoundType.forName(s).filename))
        }

        dto
    }
}
