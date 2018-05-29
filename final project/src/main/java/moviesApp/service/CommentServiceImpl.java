package moviesApp.service;

import moviesApp.model.Comment;
import moviesApp.model.CommentType;
import moviesApp.repository.CommentRepository;
import moviesApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private MovieRepository movieRepository;
    private int movieCommented;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void save(String subject, String commentText, String username, CommentType type) {

        Comment comment = new Comment();
        comment.setTitle(subject);
        comment.setCommentText(commentText);
        comment.setVotes(0);
        comment.setMovie(movieRepository.findById(getActiveCommMovie()).get());
        comment.setName(username);
        if(type.equals(CommentType.REVIEW)) {
            comment.setType(CommentType.REVIEW);
        } else {
            if (type.equals(CommentType.COMMENT)) {
                comment.setType(CommentType.COMMENT);
            }
        }
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByMovieId(int movieId) {
        return commentRepository.findByMovieId(movieId);
    }

    @Override
    public void setActiveCommMovie(int movieId) {
        this.movieCommented = movieId;
    }

    @Override
    public int getActiveCommMovie() {
        return movieCommented;
    }
}
