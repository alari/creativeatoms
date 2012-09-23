package ru.mirari.infra.ca.content

import ru.mirari.infra.ca.face.CreativeAtomType
import ru.mirari.infra.ca.atom.CreativeAtomBasicType

/**
 * @author alari
 * @since 9/20/12 10:04 PM
 */
@Singleton
class CreativeAtomTypesHolder {
    private Map<String,CreativeAtomType> specialTypes = [:]

    static CreativeAtomType byName(final String name) {
        getInstance().getByName(name)
    }

    static void register(final CreativeAtomType type) {
        getInstance().registerSpecial(type)
    }

    static Collection<CreativeAtomType> getTypes() {
        CreativeAtomBasicType.values() + getInstance().specialTypes.values()
    }

    CreativeAtomType getByName(final String name) {
        if(specialTypes.containsKey(name)) {
            return specialTypes.get(name)
        }
        CreativeAtomBasicType.byName(name)
    }

    void registerSpecial(final CreativeAtomType type) {
        specialTypes.put(type.name, type)
    }
}
