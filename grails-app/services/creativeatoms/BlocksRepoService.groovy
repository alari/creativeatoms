package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomRepo

class BlocksRepoService implements CreativeAtomRepo<Block,BlockContent,BlockRawContent> {

    List<Block> list() {
        Block.findAll()
    }

    @Override
    Block create() {
        new Block()
    }

    @Override
    Block get(Serializable id) {
        Block.get(id)
    }

    @Override
    Block save(Block atom) {
        atom?.save()
    }

    @Override
    void delete(Block atom) {
        atom.delete()
    }

    @Override
    BlockContent createContent() {
        new BlockContent()
    }

    @Override
    BlockRawContent createRawContent() {
        new BlockRawContent()
    }
}
