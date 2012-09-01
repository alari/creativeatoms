package ru.mirari.infra.ca.external

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.CreativeAtomStrategy
import ru.mirari.infra.ca.atom.CreativeAtomData

/**
 * @author alari
 * @since 9/1/12 9:41 PM
 */
abstract class ExternalContentStrategy extends CreativeAtomStrategy {
        void setExternalId(CreativeAtom atom, String id) {
            CreativeAtomData.EXTERNAL_ID.putTo(atom, id)
        }

        String getExternalId(CreativeAtom atom) {
            CreativeAtomData.EXTERNAL_ID.getFrom(atom)
        }
    }

