package creativeatoms

import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile
import ru.mirari.infra.ca.atom.dto.CreativeAtomPushBaseDTO
import ru.mirari.infra.ca.face.CreativeAtomsService

class BlocksController {

    def blocksRepoService
    CreativeAtomsService blocksService

    def index() {
        if (request.post) {
            println "got it!"
        }
        [blocks: blocksRepoService.list()]
    }

    def create(CreativeAtomPushBaseDTO creativeAtomDTO) {

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest mpr = (MultipartHttpServletRequest) request;
            CommonsMultipartFile f = (CommonsMultipartFile) mpr.getFile("file");
            creativeAtomDTO.originalFilename = f.originalFilename

            File file = File.createTempFile("atom", "ca")
            f.transferTo(file)
            creativeAtomDTO.file = file
        }

        if (creativeAtomDTO.validate()) {
            Block block = blocksService.create(creativeAtomDTO)
            block.save()
            println block.errors
        }
        redirect(action: "index")
    }
}
