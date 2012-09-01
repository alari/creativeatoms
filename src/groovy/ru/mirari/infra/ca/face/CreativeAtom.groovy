package ru.mirari.infra.ca.face

import ru.mirari.infra.ca.atom.CreativeAtomType

/**
 * @author alari
 * @since 9/1/12 9:21 PM
 */
public interface CreativeAtom<C extends CreativeAtomContent> {
    public String getTitle()
    public void setTitle(String title)

    public CreativeAtomType getType()
    public void setType(CreativeAtomType type)

    public void setContentData(String key, String value)
    public String getContentData(String key)
}
