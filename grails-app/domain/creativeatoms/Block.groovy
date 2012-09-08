package creativeatoms

import ru.mirari.infra.ca.CreativeAtomBase

class Block extends CreativeAtomBase<BlockContent, BlockRawContent> {
    private BlockContent content
    private BlockRawContent rawContent

    static constraints = {
        content nullable: true
        rawContent nullable: true
    }

    static hasOne = [content: BlockContent, rawContent: BlockRawContent]

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
    public BlockRawContent getRawContent() {
        rawContent
    }
}
