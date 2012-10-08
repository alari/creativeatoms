package creativeatoms

import ru.mirari.infra.chain.face.CreativeChainRepo
import grails.converters.JSON

import ru.mirari.infra.chain.face.CreativeChain
import org.springframework.beans.factory.annotation.Autowired

class RestCreativeChainController {

    @Autowired
    CreativeChainRepo creativeChainRepo

    def query() {
        // TODO: remove this shit
        render creativeChainRepo.list()*.getDTO(true) as JSON
    }

    def create() {
        CreativeChain chain = creativeChainRepo.create()
        chain.title = ""
        chain.draft = true
        if (chain.validate()) {
            chain.save()
        } else {
            response.status = 400
            render "not ok"
            return;
        }

        render chain.getDTO(true) as JSON
    }

    def show() {
        CreativeChain chain = creativeChainRepo.get(params.long("id"))
        if (!chain) {
            response.status = 404
            render "not found"
            return;
        }
        render chain.getDTO(true) as JSON
    }

    def save() {
        CreativeChain chain = creativeChainRepo.get(params.long("id"))
        if (!chain) {
            response.status = 404
            render "not found"
            return;
        }
        chain.title = params.title
        chain.draft = params.boolean("draft")

        creativeChainRepo.save(chain)

        render chain.getDTO(false) as JSON
    }

    def delete() {
        CreativeChain chain = creativeChainRepo.get(params.long("id"))
        if (!chain) {
            response.status = 404
            render "not found"
            return;
        }
        creativeChainRepo.delete(chain)
        render "deleted"
    }
}
