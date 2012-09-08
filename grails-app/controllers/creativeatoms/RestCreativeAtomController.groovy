package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtomsService
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.atom.CreativeAtomPushBaseDTO
import ru.mirari.infra.ca.face.CreativeAtom
import grails.converters.JSON

class RestCreativeAtomController {

    CreativeAtomsService blocksService

    def create() {
        CreativeAtomPushDTO dto = pushDTO

        if (dto.validate()) {
            CreativeAtom atom = blocksService.create(dto)
            if (atom.save()) {
                render atom.contentDTO as JSON
            }
        }
    }

    protected CreativeAtomPushDTO getPushDTO() {
        new CreativeAtomPushBaseDTO(params)
    }
}
