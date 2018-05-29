package moviesApp.controller;

import moviesApp.dto.MovieDto;
import moviesApp.model.CommentType;
import moviesApp.model.Movie;
import moviesApp.service.CommentService;
import moviesApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/addReviewsPage")
public class ReviewController {

    private CommentService commentService;
    private MovieService movieService;

    @Autowired
    public ReviewController(CommentService commentService, MovieService movieService) {
        this.commentService = commentService;
        this.movieService = movieService;
    }

    @GetMapping(params = "addReviews")
    public String addReviewPage(@RequestParam("movieId") int movieId) {

        commentService.setActiveCommMovie(movieId);
        return "addReviewsPage";
    }

    @GetMapping(params = "addReview")
    public String addReview(@RequestParam("subject") String subject, @RequestParam("commentText") String commentText, Principal principal, Model model) {

        if(commentText.length() >= 256) {
            commentService.save(subject, commentText, principal.getName(), CommentType.REVIEW);
            model.addAttribute("message", "Review added successfully!");
            return "addReviewsPage";
        } else {
            model.addAttribute("message", "Your review should be at least 256 characters long!");
            return "addReviewsPage";
        }
    }

    @PostMapping(params = "backToMovies")
    public String backPage(@ModelAttribute MovieDto movieDto, Model model) {
        List<Movie> list = movieService.findAll();
        model.addAttribute("movies", list);
        return "moviesPage";
    }
}
