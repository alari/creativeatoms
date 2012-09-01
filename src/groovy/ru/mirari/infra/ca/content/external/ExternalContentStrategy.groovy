package ru.mirari.infra.ca.content.external

import ru.mirari.infra.ca.content.CreativeAtomData
import ru.mirari.infra.ca.content.CreativeAtomStrategy
import ru.mirari.infra.ca.face.CreativeAtom

/**
 * @author alari
 * @since 9/1/12 9:41 PM
 */
abstract class ExternalContentStrategy extends CreativeAtomStrategy {
    @Override
    boolean isExternal() {
        true
    }


    void setExternalId(CreativeAtom atom, String id) {
        CreativeAtomData.EXTERNAL_ID.putTo(atom, id)
    }

    String getExternalId(CreativeAtom atom) {
        CreativeAtomData.EXTERNAL_ID.getFrom(atom)
    }
}

