package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.atom.CreativeAtomType

class Block implements CreativeAtom<BlockContent> {

    String title
    CreativeAtomType type

    Map<String,String> data = [:]

    static constraints = {
    }

    @Override
    String getContentData(String key) {
        data.get(key)
    }

    @Override
    void setContentData(String key, String value) {
        data.put(key, value)
    }
}
