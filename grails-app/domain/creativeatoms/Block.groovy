package creativeatoms

import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.atom.CreativeAtomType
import ru.mirari.infra.ca.atom.CreativeAtomContentDTO

class Block implements CreativeAtom<BlockContent,BlockRawContent> {

    def getAtomId() {
        id
    }

    String title
    CreativeAtomType type

    Map<String,String> data = [:]

    private BlockContent content
    private BlockRawContent rawContent

    static hasOne = [content: BlockContent, rawContent: BlockRawContent]

    static constraints = {
        content nullable: true
        rawContent nullable: true
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
    void setContent(BlockContent content) {
        this.content = content
    }
    @Override
    public BlockContent getContent() {
        content
    }

    @Override
    void setRawContent(BlockRawContent rawContent) {
        this.rawContent = rawContent
    }

    @Override
    CreativeAtomContentDTO getContentDTO() {
        type.strategy.getContentDTO(this)
    }

    @Override
    public BlockRawContent getRawContent() {
        rawContent
    }

    def beforeDelete() {
        type.strategy.deleteContent(this)
    }
}
