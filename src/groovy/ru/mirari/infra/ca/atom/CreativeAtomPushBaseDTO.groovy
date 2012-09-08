package ru.mirari.infra.ca.atom

import grails.validation.Validateable
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO

/**
 * @author alari
 * @since 9/1/12 10:10 PM
 */
@Validateable
class CreativeAtomPushBaseDTO implements CreativeAtomPushDTO {
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
}
