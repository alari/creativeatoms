package ru.mirari.infra.ca.content

/**
 * @author alari
 * @since 1/6/12 6:04 PM
 */
public enum CreativeAtomSoundType {
    MP3("mpeg", "sound.mp3"),
    WEBM("webm", "sound.webm"),
    OGG("ogg", "sound.ogg");

    static private Map<String, CreativeAtomSoundType> byName = [:]

    static {
        for (CreativeAtomSoundType t in CreativeAtomSoundType.values()) byName.put(t.name, t)
    }

    final String name
    final String filename

    private CreativeAtomSoundType(String t, String fn) {
        name = t
        filename = fn
    }

    static public CreativeAtomSoundType forName(String name) {
        byName.get(name.toLowerCase())
    }
}