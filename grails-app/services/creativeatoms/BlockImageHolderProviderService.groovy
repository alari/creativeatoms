package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomImageHolder
import ru.mirari.infra.ca.face.CreativeAtomImageHolderProvider

class BlockImageHolderProviderService implements CreativeAtomImageHolderProvider {

    @Override
    CreativeAtomImageHolder getImageHolder(CreativeAtom atom) {
        new BlockImageHolder(atom.atomId)
    }
}
