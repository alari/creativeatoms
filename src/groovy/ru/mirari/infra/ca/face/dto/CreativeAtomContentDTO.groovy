package ru.mirari.infra.ca.face.dto

/**
 * @author alari
 * @since 9/8/12 2:04 PM
 */
public interface CreativeAtomContentDTO {
    def id

    String title
    String type

    String text
    String externalId

    Map<String, String> sounds
    Map<String, String> images
}