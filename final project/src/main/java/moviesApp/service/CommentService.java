package moviesApp.service;

import moviesApp.dto.CommentDto;
import moviesApp.model.Comment;
import moviesApp.model.CommentType;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(int id);

    void save(String subject, String commentText, String username, CommentType type);

    List<Comment> findByMovieId(int movieId);

    void setActiveCommMovie(int movieId);

    int getActiveCommMovie();
}
