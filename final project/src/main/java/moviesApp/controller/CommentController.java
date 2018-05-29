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
@RequestMapping(value = "/addCommentsPage")
public class CommentController {

    private CommentService commentService;
    private MovieService movieService;

    @Autowired
    public CommentController(CommentService commentService, MovieService movieService) {
        this.commentService = commentService;
        this.movieService = movieService;
    }


    @GetMapping(params = "addComments")
    public String addCommentsPage(@RequestParam("movieId") int movieId, Model model) {

        commentService.setActiveCommMovie(movieId);
        return "addCommentsPage";
    }

    @GetMapping(params = "addComment")
    public String addComment(@RequestParam("subject") String subject, @RequestParam("commentText") String commentText, Principal principal, Model model) {

        if (commentText.length() < 256 && commentText.length() > 0) {
            commentService.save(subject, commentText, principal.getName(), CommentType.COMMENT);
            model.addAttribute("message", "Comment added successfully!");
            return "addCommentsPage";
        } else {
            model.addAttribute("message", "Your comment should be between 1 and 256 characters long!");
            return "addCommentsPage";
        }
    }

    @PostMapping(params = "backToMovies")
    public String backPage(@ModelAttribute MovieDto movieDto, Model model) {
        List<Movie> list = movieService.findAll();
        model.addAttribute("movies", list);
        return "moviesPage";
    }
}
