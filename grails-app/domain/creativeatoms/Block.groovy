package creativeatoms

import ru.mirari.infra.ca.CreativeAtomBase

import ru.mirari.infra.chain.face.CreativeChainable

class Block extends CreativeAtomBase<BlockContent> implements CreativeChainable<Post> {
    private BlockContent content

    static constraints = {
        content nullable: true, unique: true
    }

    static hasOne = [content: BlockContent]
    static belongsTo = [chain:Post]

    @Override
    void setContent(BlockContent content) {
        this.content = content
    }

    @Override
    public BlockContent getContent() {
        content
    }
}
