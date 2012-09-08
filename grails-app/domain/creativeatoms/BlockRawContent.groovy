package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomRawContent

class BlockRawContent implements CreativeAtomRawContent {

    Block block
    static belongsTo = [block: Block]

    String text

    static constraints = {
        text maxSize: 65536
    }
}
