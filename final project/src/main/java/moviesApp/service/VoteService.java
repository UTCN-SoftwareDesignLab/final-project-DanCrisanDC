package moviesApp.service;

import moviesApp.model.Vote;

import java.util.List;

public interface VoteService {
    List<Vote> findAll();

    void upvote(int commentId, int userId);

    void downvote(int commentId, int userId);
}
