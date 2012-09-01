package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomRepo

class BlocksRepoService implements CreativeAtomRepo<Block> {

    List<Block> list() {
        Block.findAll()
    }

    @Override
    Block create() {
        new Block()
    }
}
