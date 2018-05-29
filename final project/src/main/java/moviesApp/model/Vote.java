package moviesApp.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int commentId;
    private int userId;
    @Enumerated(EnumType.STRING)
    private VoteStatus voteStatus;

    public Vote() {}

    @Autowired
    public Vote(int commentId, int userId, VoteStatus voteStatus) {
        this.commentId = commentId;
        this.userId = userId;
        this.voteStatus = voteStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public VoteStatus getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(VoteStatus voteStatus) {
        this.voteStatus = voteStatus;
    }
}
