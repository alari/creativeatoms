package creativeatoms

import ru.mirari.infra.ca.chain.CreativeChain
import ru.mirari.infra.ca.chain.CreativeChainDTO
import ru.mirari.infra.ca.chain.CreativeChainBaseDTO

class Post implements CreativeChain<Block> {

    String title

    List<Block> atoms = []

    static hasMany = [atoms:Block]

    static constraints = {
    }

    @Override
    void addToAtoms(Block atom) {
        atoms.add(atom)
    }

    @Override
    boolean removeFromAtoms(Block atom) {
        atoms.remove(atom)
    }

    @Override
    CreativeChainDTO getDTO(boolean withAtoms) {
        new CreativeChainBaseDTO(this, withAtoms)
    }

    @Override
    def getChainId() {
        id
    }
}

