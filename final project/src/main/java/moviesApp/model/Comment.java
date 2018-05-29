package moviesApp.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String name;
    private String commentText;
    private double votes;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Enumerated(EnumType.STRING)
    private CommentType type;

    public Comment() {}

    @Autowired
    public Comment(String title, String name, String commentText, double votes, Movie movie, CommentType type) {
        this.title = title;
        this.name = name;
        this.commentText = commentText;
        this.votes = votes;
        this.movie = movie;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }
}
