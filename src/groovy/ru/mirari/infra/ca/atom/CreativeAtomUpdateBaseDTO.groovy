package ru.mirari.infra.ca.atom

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import org.springframework.web.multipart.commons.CommonsMultipartFile

/**
 * @author alari
 * @since 9/8/12 1:56 PM
 */
class CreativeAtomUpdateBaseDTO extends CreativeAtomContentBaseDTO implements CreativeAtomUpdateDTO {
    CreativeAtomUpdateBaseDTO(CreativeAtom atom) {
        super(atom)
    }

    String externalUrl
    File file
    String originalFilename

    public CreativeAtomUpdateBaseDTO(final Map params) {
        super();
        params?.each { String k, v ->
            if(!this.hasProperty(k)) return;
            if(k == "file") return;
            this[k] = v
        }
        if(params['file'] instanceof CommonsMultipartFile) {
            CommonsMultipartFile f = (CommonsMultipartFile)params['file']
            file = File.createTempFile("atom", "ca")
            f.transferTo(file)
            originalFilename = f.originalFilename
        }
    }
}
