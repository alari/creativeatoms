package creativeatoms

import ru.mirari.infra.ca.chain.CreativeChainRepo

class PostsRepoService implements CreativeChainRepo<Post> {

    @Override
    Post create() {
        new Post()
    }

    @Override
    void delete(Post chain) {
        chain.atoms.each {it.delete()}
        chain.delete()
    }

    @Override
    Post get(Serializable id) {
        Post.get(id)
    }
}
