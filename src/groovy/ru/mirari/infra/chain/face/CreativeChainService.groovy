package ru.mirari.infra.chain.face

/**
 * @author alari
 * @since 10/8/12 10:45 PM
 */
public interface CreativeChainService<C extends CreativeChain, A extends CreativeChainable<C>> {
    void setChain(A atom, CreativeChainablePushDTO dto)
}