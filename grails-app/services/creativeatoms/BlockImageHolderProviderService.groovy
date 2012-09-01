package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomImageHolderProvider
import ru.mirari.infra.ca.face.CreativeAtomImageHolder
import ru.mirari.infra.ca.face.CreativeAtom

class BlockImageHolderProviderService implements CreativeAtomImageHolderProvider {

    @Override
    CreativeAtomImageHolder getImageHolder(CreativeAtom atom) {
        new BlockImageHolder(atom.id)
    }
}
