package ru.mirari.infra.ca

import ru.mirari.infra.ca.face.CreativeAtomType
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomContent
import ru.mirari.infra.ca.face.CreativeAtomRawContent
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.ca.atom.CreativeAtomBasicType

/**
 * @author alari
 * @since 9/8/12 11:28 PM
 */
abstract class CreativeAtomBase<C extends CreativeAtomContent, R extends CreativeAtomRawContent> implements CreativeAtom<C,R> {
    String title = ""

    String typeName = ""

    Map<String,String> data = [:]

    def getAtomId() {
        getId()
    }

    @Override
    public CreativeAtomType type() {
        CreativeAtomBasicType.byName(typeName)
    }

    @Override
    public void type(CreativeAtomType type) {
        this.typeName = type.name()
    }

    @Override
    String getContentData(String key) {
        data.get(key)
    }

    @Override
    void setContentData(String key, String value) {
        data.put(key, value)
    }

    @Override
    CreativeAtomContentDTO getContentDTO() {
        type().strategy.getContentDTO(this)
    }

    @Override
    CreativeAtomUpdateDTO getUpdateDTO() {
        type().strategy.getUpdateDTO(this)
    }

    def beforeDelete() {
        type().strategy.deleteContent(this)
    }
}
