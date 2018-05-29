package moviesApp.service;

import moviesApp.model.Comment;
import moviesApp.model.Vote;
import moviesApp.model.VoteStatus;
import moviesApp.repository.CommentRepository;
import moviesApp.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{

    private VoteRepository voteRepository;
    private CommentRepository commentRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, CommentRepository commentRepository) {

        this.voteRepository = voteRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    @Override
    public void upvote(int commentId, int userId) {
        Comment comment = commentRepository.findById(commentId).get();
        List<Vote> votes = voteRepository.findAll();

        for(Vote v : votes) {
            if(v.getCommentId() == comment.getId() && v.getUserId() == userId && v.getVoteStatus().equals(VoteStatus.UPVOTED)) {
                return;
            }
            if (v.getCommentId() == comment.getId() && v.getUserId() == userId && v.getVoteStatus().equals(VoteStatus.DOWNVOTED)) {
                comment.setVotes(comment.getVotes()+1);
                v.setVoteStatus(VoteStatus.NOTVOTED);
                voteRepository.save(v);
                commentRepository.save(comment);
                return;
            } else {
                if (v.getCommentId() == comment.getId() && v.getUserId() == userId && v.getVoteStatus().equals(VoteStatus.NOTVOTED)) {
                    comment.setVotes(comment.getVotes() + 1);
                    v.setVoteStatus(VoteStatus.UPVOTED);
                    voteRepository.save(v);
                    commentRepository.save(comment);
                    return;
                }
            }
        }
        comment.setVotes(comment.getVotes() + 1);
        Vote vote = new Vote(comment.getId(), userId, VoteStatus.UPVOTED);
        voteRepository.save(vote);
        commentRepository.save(comment);
    }

    @Override
    public void downvote(int commentId, int userId) {
        Comment comment = commentRepository.findById(commentId).get();
        List<Vote> votes = voteRepository.findAll();

        for(Vote v : votes) {
            if(v.getCommentId() == comment.getId() && v.getUserId() == userId && v.getVoteStatus().equals(VoteStatus.DOWNVOTED)) {
                return;
            }
            if (v.getCommentId() == comment.getId() && v.getUserId() == userId && v.getVoteStatus().equals(VoteStatus.UPVOTED)) {
                comment.setVotes(comment.getVotes()-1);
                v.setVoteStatus(VoteStatus.NOTVOTED);
                voteRepository.save(v);
                commentRepository.save(comment);
                return;
            } else {
                if (v.getCommentId() == comment.getId() && v.getUserId() == userId && v.getVoteStatus().equals(VoteStatus.NOTVOTED)) {
                    comment.setVotes(comment.getVotes() - 1);
                    v.setVoteStatus(VoteStatus.DOWNVOTED);
                    voteRepository.save(v);
                    commentRepository.save(comment);
                    return;
                }
            }
        }
        comment.setVotes(comment.getVotes() - 1);
        Vote vote = new Vote(comment.getId(), userId, VoteStatus.DOWNVOTED);
        voteRepository.save(vote);
        commentRepository.save(comment);
    }
}
