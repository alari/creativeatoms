package ru.mirari.infra.chain

import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.chain.face.CreativeChain
import ru.mirari.infra.chain.face.CreativeChainDTO

/**
 * @author alari
 * @since 9/27/12 9:52 PM
 */
class CreativeChainBaseDTO implements CreativeChainDTO {
    String id

    String title
    boolean draft

    List<CreativeAtomContentDTO> atoms = []

    CreativeChainBaseDTO(final CreativeChain chain, boolean withAtoms) {
        id = chain.chainId.toString()
        if(withAtoms) atoms = chain.atoms?.collect {CreativeAtom a -> a?.contentDTO}
        title = chain.title
        draft = chain.draft
    }
}
