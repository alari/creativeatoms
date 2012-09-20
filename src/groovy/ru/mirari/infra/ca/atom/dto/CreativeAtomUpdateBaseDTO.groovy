package ru.mirari.infra.ca.atom.dto

import org.springframework.web.multipart.commons.CommonsMultipartFile
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import grails.validation.Validateable

/**
 * @author alari
 * @since 9/8/12 1:56 PM
 */
@Validateable
class CreativeAtomUpdateBaseDTO extends CreativeAtomContentBaseDTO implements CreativeAtomUpdateDTO {
    CreativeAtomUpdateBaseDTO(CreativeAtom atom) {
        super(atom)
    }

    static constraints = {

    }

    String externalUrl
    File file
    String originalFilename

    public CreativeAtomUpdateBaseDTO(final Map params) {
        super();
        params?.each { String k, v ->
            if(!v) return;
            if (!this.hasProperty(k)) return;
            if (k == "file" || k == "errors" || k == "class") return;
            this[k] = v
        }
        if (params['file'] instanceof CommonsMultipartFile) {
            CommonsMultipartFile f = (CommonsMultipartFile) params['file']
            file = File.createTempFile("atom", "ca")
            f.transferTo(file)
            originalFilename = f.originalFilename
        }
    }
}
