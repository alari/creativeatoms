package ru.mirari.infra.ca.content

import ru.mirari.infra.ca.face.CreativeAtom

/**
 * @author alari
 * @since 1/6/12 6:07 PM
 */
public enum CreativeAtomData {
    SOUND_TYPES("sound_types"),
    EXTERNAL_ID("external_id")

    public final String key;

    CreativeAtomData(String key) {
        this.key = key
    }

    String getFrom(CreativeAtom atom) {
        atom.getContentData(key)
    }

    Set<String> getSetFrom(CreativeAtom atom) {
        String data = atom.getContentData(key)
        if(!data) {
            return null
        }
        Set result = []
        result.addAll data.split("\t")
        result
    }

    void putTo(CreativeAtom atom, String value) {
        atom.setContentData(key, value)
    }

    void putTo(CreativeAtom atom, Collection<String> collection) {
        atom.setContentData(key, collection.join("\t"))
    }
}