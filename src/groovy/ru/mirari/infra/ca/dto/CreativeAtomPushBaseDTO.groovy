package ru.mirari.infra.ca.dto

import grails.validation.Validateable
import org.springframework.web.multipart.commons.CommonsMultipartFile
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.chain.face.CreativeChainablePushDTO

/**
 * @author alari
 * @since 9/1/12 10:10 PM
 */
@Validateable
class CreativeAtomPushBaseDTO implements CreativeAtomPushDTO, CreativeChainablePushDTO {
    String chainId

    String title
    String externalUrl

    File file
    String originalFilename

    String text

    static constraints = {
        title nullable: true
        externalUrl nullable: true
        file nullable: true
        originalFilename nullable: true
        text nullable: true
    }

    public CreativeAtomPushBaseDTO(final Map params) {
        params?.each { String k, v ->
            if (!this.hasProperty(k)) return;
            if (k == "file") return;
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
