package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomContent

class BlockContent implements CreativeAtomContent {

    Block block
    static belongsTo = [block:Block]

    String text

    static constraints = {
        text maxSize: 65536
    }
}
