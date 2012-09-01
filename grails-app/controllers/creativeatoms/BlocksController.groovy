package creativeatoms

import ru.mirari.infra.ca.atom.CreativeAtomDTO
import ru.mirari.infra.ca.CreativeAtomsService

class BlocksController {

    def blocksRepoService
    CreativeAtomsService blocksService

    def index() {
        if (request.post) {
            println "got it!"
        }
        [blocks: blocksRepoService.list()]
    }

    def create(CreativeAtomDTO creativeAtomDTO) {
        if (creativeAtomDTO.validate()) {
            Block block = blocksService.create(creativeAtomDTO)
            block.save()
            println block.errors
        }
        redirect(action: "index")
    }
}
