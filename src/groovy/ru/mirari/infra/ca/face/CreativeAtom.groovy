package ru.mirari.infra.ca.face

import ru.mirari.infra.ca.atom.CreativeAtomType
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO

/**
 * @author alari
 * @since 9/1/12 9:21 PM
 */
public interface CreativeAtom<C extends CreativeAtomContent, R extends CreativeAtomRawContent> {
    public def getAtomId()

    public String getTitle()

    public void setTitle(String title)

    public CreativeAtomType getType()

    public void setType(CreativeAtomType type)

    public void setContentData(String key, String value)

    public String getContentData(String key)

    public C getContent()

    void setContent(C content)

    public R getRawContent()

    void setRawContent(R rawContent)

    CreativeAtomContentDTO getContentDTO()

    CreativeAtomUpdateDTO getUpdateDTO()
}
