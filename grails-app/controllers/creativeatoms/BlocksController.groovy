package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomsService

class BlocksController {

    def blocksRepoService
    CreativeAtomsService blocksService

    def index() {
        [blocks: blocksRepoService.list()]
    }
}
