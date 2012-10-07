package creativeatoms

import ru.mirari.infra.ca.chain.CreativeChain
import ru.mirari.infra.ca.chain.CreativeChainDTO
import ru.mirari.infra.ca.chain.CreativeChainBaseDTO

class Post implements CreativeChain<Block> {

    String title

    List<Block> atoms = []

    boolean draft

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
    void moveAtom(Block atom, int index) {
        if(!atoms.contains(atom)) {
            return;
        }
        final int oldIndex = atoms.indexOf(atom)
        if(oldIndex == index) return;
        List<Block> _atoms = []
        _atoms.addAll(atoms.subList(0, Math.min(oldIndex,index)-1))
        _atoms.add(index<oldIndex ? atom : atoms[Math.min(oldIndex,index)])
        _atoms.addAll(atoms.subList(Math.min(oldIndex,index), Math.max(oldIndex,index)-1))
        _atoms.add(index>oldIndex ? atom : atoms[Math.max(oldIndex,index)])
        _atoms.addAll(atoms.subList(Math.max(oldIndex,index)+1, atoms.size()))
        atoms = _atoms
    }

    @Override
    CreativeChainDTO getDTO(boolean withAtoms) {
        new CreativeChainBaseDTO(this, withAtoms)
    }

    @Override
    def getChainId() {
        id
    }

    boolean isDraft() {
        draft
    }
}

