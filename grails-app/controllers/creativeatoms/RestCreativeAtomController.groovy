package creativeatoms

import grails.converters.JSON
import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomRepo
import ru.mirari.infra.ca.face.CreativeAtomsService
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO

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

    def show(id) {
        CreativeAtom atom = creativeAtomRepo.get(id)
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

    def update(id) {
        CreativeAtom atom = creativeAtomRepo.get(id)
        if (!atom) {
            response.status = 404
            return;
        }

        CreativeAtomPushDTO dto = creativeAtomsService.getUpdateDTO(params)
        if (dto.validate()) {
            creativeAtomsService.update(atom, dto)
            render atom.contentDTO as JSON
        }
    }

    def delete(id) {
        CreativeAtom atom = creativeAtomRepo.get(id)
        if (!atom) {
            response.status = 404
            return;
        }

        creativeAtomRepo.delete(atom)
    }
}
