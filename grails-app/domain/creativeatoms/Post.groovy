package creativeatoms

import ru.mirari.infra.ca.ChainContent

class Post {

    String title

    boolean draft

    private ChainContent contentCache

    static hasOne = [chainContent:String]
    static transients = ['content', 'contentCache']

    ChainContent getContent() {
        if(!contentCache) {
            if(chainContent) {
                contentCache = ChainContent.forJson(chainContent)
            }
        }
        contentCache
    }

    void setContent(ChainContent content) {
        contentCache = content
    }

    def beforeSave() {
        if(contentCache) {
            chainContent = contentCache.toJson()
        }
    }

    static constraints = {
    }

    boolean isDraft() {
        draft
    }
}

