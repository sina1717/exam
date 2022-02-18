package service;

import Entity.Post;
import repository.PostRepository;

import java.util.List;

public class PostService implements BaseService<Post> {
    public PostService() {
        postRepository = new PostRepository();
    }

    private PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void update(Post post) {
        postRepository.update(post);
    }

    @Override
    public void delete(int id) {
        postRepository.delete(id);
    }

    @Override
    public Post findById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
