package creativeatoms

import javax.annotation.PostConstruct
import ru.mirari.infra.ApplicationContextHolder
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtomContentRepo
import ru.mirari.infra.ca.CreativeAtomsBaseService

class BlocksService extends CreativeAtomsBaseService<Block, BlockContent, BlockRawContent> {
    @PostConstruct
    void init() {
        creativeAtomContentRepo = ApplicationContextHolder.getBean("blockContentsRepoService") as CreativeAtomContentRepo<BlockContent>
        creativeAtomRepo = ApplicationContextHolder.getBean("blocksRepoService") as CreativeAtomRepo<Block>
    }
}
