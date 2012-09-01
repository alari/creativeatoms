package ru.mirari.infra.ca.atom

import grails.validation.Validateable

/**
 * @author alari
 * @since 9/1/12 10:10 PM
 */
@Validateable
class CreativeAtomDTO {
    String title
    String externalUrl

    static constraints = {
        title nullable: true
        externalUrl nullable: true
    }
}
