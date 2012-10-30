package ru.mirari.infra.ca.face

/**
 * @author alari
 * @since 9/1/12 9:23 PM
 */
public interface CreativeAtomRepo<A extends CreativeAtom, C extends CreativeAtomContent> {
    A create()

    A get(Serializable id)

    A save(A atom)

    void delete(A atom)

    C createContent()
}