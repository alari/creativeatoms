package ru.mirari.infra.chain.face

/**
 * @author alari
 * @since 10/8/12 10:22 PM
 */
public interface CreativeChainable<C extends CreativeChain> {
    void setChain(C chain)
    C getChain()
}