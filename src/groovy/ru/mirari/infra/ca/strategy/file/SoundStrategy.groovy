package ru.mirari.infra.ca.strategy.file

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.Atom
import ru.mirari.infra.ca.strategy.SoundType
import ru.mirari.infra.file.FileHolder
import ru.mirari.infra.file.FileInfo

/**
 * @author alari
 * @since 1/6/12 5:59 PM
 */
@Component
class SoundStrategy extends FilesHolderStrategy {
    String filesBucket = "mirarisounds"

    @Override
    protected Holder getFileHolder(Atom unit) {
        Holder holder = super.getFileHolder(unit)
        holder.filesBucket = filesBucket
        holder
    }

    private Set<String> getSoundTypes(Atom unit) {
        CreativeAtomData.SOUND_TYPES.getSetFrom(unit)
    }

    private void setSoundTypes(Atom unit, Set<String> types) {
        CreativeAtomData.SOUND_TYPES.putTo(unit, types)
    }

    private List<String> getFileNames(Atom unit) {
        List<String> files = []
        for (String s : getSoundTypes(unit)) {
            files.add(SoundType.forName(s).filename)
        }
        files
    }

    @Override
    void setContentFile(Atom unit, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;
        FileHolder holder = getFileHolder(unit)
        SoundType soundType = SoundType.forName(fileInfo.subType)

        fileStorageService.store(fileInfo.file, holder, soundType.filename)

        Set<String> currentTypes = getSoundTypes(unit) ?: []
        currentTypes.add(soundType.name)
        setSoundTypes(unit, currentTypes)

        unit.title = fileInfo.title
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        if (type.mediaType != "audio") return false;
        SoundType.forName(type.subType) != null
    }

    @Override
    void deleteContent(Atom unit) {
        Holder holder = getFileHolder(unit)
        holder.fileNames = getFileNames(unit)
        fileStorageService.delete(holder)
        unit.sounds = [:]
    }

    Atom getForRender(Atom atom) {
        FileHolder holder = getFileHolder(atom)
        atom.sounds.keySet().each {
            atom.sounds.put(it, fileStorageService.getUrl(holder, SoundType.forName(it).filename))
        }
        atom
    }
}
