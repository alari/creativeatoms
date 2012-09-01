package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomContentRepo

class BlockContentsRepoService implements CreativeAtomContentRepo<BlockContent> {

    BlockContent create() {
        new BlockContent()
    }
}
