package ru.mirari.infra.ca.chain

import ru.mirari.infra.ca.face.CreativeAtom

/**
 * @author alari
 * @since 9/27/12 9:46 PM
 */
public interface CreativeChain<A extends CreativeAtom> {
    def getChainId()

    void setTitle(String title)
    String getTitle()

    List<A> getAtoms()
    void addToAtoms(A atom)
    boolean removeFromAtoms(A atom)
    void moveAtom(A atom, int index)

    CreativeChainDTO getDTO(boolean withAtoms)
}