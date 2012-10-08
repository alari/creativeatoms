package creativeatoms

import ru.mirari.infra.chain.face.CreativeChainRepo
import ru.mirari.infra.chain.face.CreativeChainService
import ru.mirari.infra.chain.face.CreativeChainablePushDTO

class PostsRepoService implements CreativeChainRepo<Post>, CreativeChainService<Post,Block> {

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

    @Override
    void save(Post chain) {
        chain.save()
    }

    List<Post> list() {
        Post.list()
    }

    @Override
    void setChain(Block atom, CreativeChainablePushDTO dto) {
        Post post = get(dto.chainId)
        post?.addToAtoms(atom)
    }
}
