package creativeatoms

import ru.mirari.infra.ca.CreativeAtomsService
import javax.annotation.PostConstruct
import ru.mirari.infra.ApplicationContextHolder
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtomContentRepo

class BlocksService extends CreativeAtomsService<Block, BlockContent, BlockRawContent> {
    @PostConstruct
    void init() {
        creativeAtomContentRepo = ApplicationContextHolder.getBean("blockContentsRepoService") as CreativeAtomContentRepo<BlockContent>
        creativeAtomRepo = ApplicationContextHolder.getBean("blocksRepoService") as CreativeAtomRepo<Block>
    }
}
