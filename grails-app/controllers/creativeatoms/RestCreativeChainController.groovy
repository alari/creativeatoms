package creativeatoms

import ru.mirari.infra.ca.chain.CreativeChainRepo
import grails.converters.JSON
import ru.mirari.infra.ca.chain.CreativeChainDTO
import ru.mirari.infra.ca.chain.CreativeChain
import org.springframework.beans.factory.annotation.Autowired

class RestCreativeChainController {

    @Autowired
    CreativeChainRepo creativeChainRepo

    def query() {
        render creativeChainRepo.list()*.getDTO(true) as JSON
    }

    def create() {
        CreativeChain chain = creativeChainRepo.create()
        chain.title = ""
        chain.draft = true
        if (chain.validate()) {
            chain.save()
        } else {
            println chain.errors
        }

        render chain.getDTO(true) as JSON
    }

    def show() {
        /*CreativeAtom atom = creativeAtomRepo.get(params.id)
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
        render dto as JSON   */
    }

    def save() {
        /*CreativeAtom atom = creativeAtomRepo.get(params.long("id"))
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
        } */
    }

    def delete() {
        /*CreativeAtom atom = creativeAtomRepo.get(params.id)
        if (!atom) {
            response.status = 404
            render "not found"
            return;
        }

        creativeAtomRepo.delete(atom)
        render "deleted"*/
    }
}
