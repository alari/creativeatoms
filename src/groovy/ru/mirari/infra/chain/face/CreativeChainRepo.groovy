package ru.mirari.infra.chain.face

/**
 * @author alari
 * @since 9/27/12 9:51 PM
 */
public interface CreativeChainRepo<C extends CreativeChain> {
    C create()
    void delete(C chain)
    C get(Serializable id)
    void save(C chain)
}