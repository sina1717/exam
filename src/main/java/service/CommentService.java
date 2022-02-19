package service;

import Entity.Comment;
import Entity.Post;
import repository.CommentRepository;

import java.util.List;

public class CommentService implements BaseService<Comment> {
    private CommentRepository commentRepository;

    public CommentService() {
        commentRepository =new CommentRepository();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
            commentRepository.update(comment);
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentByPost(Post post){
        return commentRepository.findCommentByPost(post);
    }
}
