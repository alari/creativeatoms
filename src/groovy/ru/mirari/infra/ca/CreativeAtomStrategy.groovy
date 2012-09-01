package ru.mirari.infra.ca

import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom

/**
 * @author alari
 * @since 9/1/12 9:29 PM
 */
@Component
abstract class CreativeAtomStrategy {
    abstract void buildContentByUrl(CreativeAtom atom, URL url);

    abstract boolean isUrlSupported(URL url);
}
