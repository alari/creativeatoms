package ru.mirari.infra.ca

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomContent
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.ca.content.CreativeAtomStrategy
import ru.mirari.infra.ca.content.CreativeAtomStrategiesHolder

/**
 * @author alari
 * @since 9/8/12 11:28 PM
 */
abstract class CreativeAtomBase<C extends CreativeAtomContent> implements CreativeAtom<C> {
    String title = ""

    String typeName = ""

    Map<String,String> data = [:]

    def getAtomId() {
        getId()
    }

    @Override
    CreativeAtomStrategy strategy() {
        CreativeAtomStrategiesHolder.byName(typeName)
    }

    void strategy(final CreativeAtomStrategy strategy) {
        this.typeName = strategy.name
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
        strategy().getContentDTO(this)
    }

    @Override
    CreativeAtomUpdateDTO getUpdateDTO() {
        strategy().getUpdateDTO(this)
    }

    def beforeDelete() {
        strategy()?.deleteContent(this)
    }
}
