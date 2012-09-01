package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomRawContentRepo

/**
 * @author alari
 * @since 9/1/12 11:53 PM
 */
class BlockRawContentsRepoService implements CreativeAtomRawContentRepo<BlockRawContent> {
    BlockRawContent create() {
        new BlockRawContent()
    }
}
