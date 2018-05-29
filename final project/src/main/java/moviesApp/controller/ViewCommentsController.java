package moviesApp.controller;

import moviesApp.dto.CommentDto;
import moviesApp.dto.MovieDto;
import moviesApp.model.Comment;
import moviesApp.model.Movie;
import moviesApp.model.User;
import moviesApp.model.VoteStatus;
import moviesApp.service.CommentService;
import moviesApp.service.MovieService;
import moviesApp.service.UserService;
import moviesApp.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "commentsPage")
public class ViewCommentsController {

    private CommentService commentService;
    private UserService userService;
    private MovieService movieService;
    private VoteService voteService;

    @Autowired
    public ViewCommentsController(CommentService commentService, UserService userService, MovieService movieService, VoteService voteService) {
        this.commentService = commentService;
        this.userService = userService;
        this.movieService = movieService;
        this.voteService = voteService;
    }

    @GetMapping(params = "viewComments")
    public String getCommentsPage(@RequestParam("movieId") int movieId, Model model) {

        model.addAttribute("commentDto", new CommentDto());

        List<Comment> list = commentService.findByMovieId(movieId);
        model.addAttribute("comments", list);

        return "commentsPage";
    }

    @GetMapping(params = "upvote")
    public String upvote(@RequestParam("commentId") int commentId, @RequestParam("cmovieId") int cmovieId, Model model, Principal principal) {
        model.addAttribute("commentDto", new CommentDto());

        User user = userService.findByUsername(principal.getName());
        voteService.upvote(commentId, user.getId());
        List<Comment> list = commentService.findByMovieId(cmovieId);
        model.addAttribute("comments", list);
        return "commentsPage";
    }

    @GetMapping(params = "downvote")
    public String downvote(@RequestParam("commentId") int commentId, @RequestParam("cmovieId") int cmovieId, Model model, Principal principal) {
        model.addAttribute("commentDto", new CommentDto());

        User user = userService.findByUsername(principal.getName());
        voteService.downvote(commentId, user.getId());
        List<Comment> list = commentService.findByMovieId(cmovieId);
        model.addAttribute("comments", list);
        return "commentsPage";
    }

    @PostMapping(params = "backToMovies")
    public String backPage(@ModelAttribute MovieDto movieDto, Model model) {
        List<Movie> list = movieService.findAll();
        model.addAttribute("movies", list);
        return "moviesPage";
    }
}
