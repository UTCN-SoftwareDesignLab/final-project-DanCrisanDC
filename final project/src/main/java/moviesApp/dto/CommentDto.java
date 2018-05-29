package moviesApp.dto;

import moviesApp.model.CommentType;
import moviesApp.model.Movie;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentDto {

    public int id;
    @NotNull(message = "Please type in a title for your comment.")
    public String title;
    @NotNull
    public String name;
    @Size(min = 1, message = "Your review should be at least 1 character long.")
    public String commentText;
    @NotNull
    public double votes;
    @NotNull
    public Movie movie;
    @NotNull
    public CommentType type;

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
