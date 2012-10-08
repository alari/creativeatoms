package creativeatoms

import ru.mirari.infra.ca.CreativeAtomBase

import ru.mirari.infra.chain.face.CreativeChainable

class Block extends CreativeAtomBase<BlockContent, BlockRawContent> implements CreativeChainable<Post> {
    private BlockContent content
    private BlockRawContent rawContent

    static constraints = {
        content nullable: true, unique: true
        rawContent nullable: true, unique: true
    }

    static hasOne = [content: BlockContent, rawContent: BlockRawContent]
    static belongsTo = [chain:Post]

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
