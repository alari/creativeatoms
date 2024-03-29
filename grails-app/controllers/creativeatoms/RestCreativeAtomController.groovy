package creativeatoms

import grails.converters.JSON
import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtomsService
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.chain.face.CreativeChainable
import ru.mirari.infra.chain.face.CreativeChainService
import ru.mirari.infra.chain.face.CreativeChainablePushDTO

class RestCreativeAtomController {

    @Autowired
    CreativeAtomsService creativeAtomsService
    @Autowired
    CreativeAtomRepo creativeAtomRepo

    def query() {
        render creativeAtomRepo.list()*.contentDTO as JSON
    }

    def create() {
        CreativeAtomPushDTO dto = creativeAtomsService.getPushDTO(params)

        if (dto.validate()) {
            CreativeAtom atom = creativeAtomsService.create(dto)
            if (atom) {
                render atom.contentDTO as JSON
                return;
            }
        }
        response.status = 400
        render "error"
    }

    def show() {
        CreativeAtom atom = creativeAtomRepo.get(params.id)
        if (!atom) {
            response.status = 404
            render "not found"
            return;
        }
        CreativeAtomContentDTO dto
        if (params.update) {
            dto = atom.updateDTO
        } else {
            dto = atom.contentDTO
        }
        render dto as JSON
    }

    def save() {
        CreativeAtom atom = creativeAtomRepo.get(params.long("id"))
        if (!atom) {
            response.status = 404
            render "not found"
            return;
        }
        CreativeAtomUpdateDTO dto = creativeAtomsService.getUpdateDTO(params)
        if (creativeAtomsService.update(atom, dto)) {
            render atom.contentDTO as JSON
        } else {
            response.status = 400
            render "not updated"
        }
    }

    def delete() {
        CreativeAtom atom = creativeAtomRepo.get(params.id)
        if (!atom) {
            response.status = 404
            render "not found"
            return;
        }

        creativeAtomRepo.delete(atom)
        render "deleted"
    }
}
