package ru.mirari.infra.chain

import ru.mirari.infra.chain.face.CreativeChain
import ru.mirari.infra.chain.face.CreativeChainable

import ru.mirari.infra.chain.face.CreativeChainRepo
import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.chain.face.CreativeChainablePushDTO
import ru.mirari.infra.chain.face.CreativeChainService

/**
 * @author alari
 * @since 10/8/12 10:27 PM
 */
class CreativeChainBaseService<C extends CreativeChain, A extends CreativeChainable<C>> implements CreativeChainService<C,A> {
    @Autowired
    CreativeChainRepo<C> creativeChainRepo

    void setChain(A atom, CreativeChainablePushDTO dto) {
        C chain = creativeChainRepo.get(dto.chainId)
        chain.addToAtoms(atom)
    }
}
