package ru.mirari.infra.chain.face

/**
 * @author alari
 * @since 9/27/12 9:46 PM
 */
public interface CreativeChain<A extends CreativeChainable> {
    def getChainId()

    void setTitle(String title)
    String getTitle()

    boolean isDraft()
    void setDraft(boolean draft)

    List<A> getAtoms()
    void addToAtoms(A atom)
    boolean removeFromAtoms(A atom)
    void moveAtom(A atom, int index)

    CreativeChainDTO getDTO(boolean withAtoms)
}