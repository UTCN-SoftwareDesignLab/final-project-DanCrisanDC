package moviesApp.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    private String genre;
    private Date launchDate;
    private int duration;
    private String description;
    private double rating;
    private int revenue;
    private int budget;

    public Movie() {}

    @Autowired
    public Movie(String name, String genre, Date launchDate, int duration, String description, double rating, int revenue, int budget) {
        this.name = name;
        this.genre = genre;
        this.launchDate = launchDate;
        this.duration = duration;
        this.description = description;
        this.rating = rating;
        this.revenue = revenue;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", launchDate=" + launchDate +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", revenue=" + revenue +
                ", budget=" + budget +
                '}';
    }
}
