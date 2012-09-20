package creativeatoms

import grails.converters.JSON
import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtomsService
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO

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
        CreativeAtom atom = creativeAtomRepo.get(params.id)
        if (!atom) {
            response.status = 404
            return;
        }
        CreativeAtomUpdateDTO dto = creativeAtomsService.getUpdateDTO(params)
        if (creativeAtomsService.update(atom, dto)) {
            render atom.contentDTO as JSON
        } else {
            response.status = 400
        }
    }

    def delete() {
        CreativeAtom atom = creativeAtomRepo.get(params.id)
        if (!atom) {
            response.status = 404
            return;
        }

        creativeAtomRepo.delete(atom)
    }
}
