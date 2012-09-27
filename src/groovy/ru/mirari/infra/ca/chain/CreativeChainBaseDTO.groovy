package ru.mirari.infra.ca.chain

import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.CreativeAtom

/**
 * @author alari
 * @since 9/27/12 9:52 PM
 */
class CreativeChainBaseDTO implements CreativeChainDTO {
    String id

    String title

    List<CreativeAtomContentDTO> atoms = []

    CreativeChainBaseDTO(final CreativeChain chain, boolean withAtoms) {
        id = chain.chainId.toString()
        if(withAtoms) atoms = chain.atoms.collect {CreativeAtom a -> a.contentDTO}
        title = chain.title
    }
}
