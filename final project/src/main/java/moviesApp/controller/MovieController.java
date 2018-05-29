package moviesApp.controller;

import moviesApp.config.Connection;
import moviesApp.dto.MovieDto;
import moviesApp.model.Movie;
import moviesApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/moviesPage")
public class MovieController {

    private MovieService movieService;
    private Connection connection;

    @Autowired
    public MovieController(MovieService movieService, Connection connection) {
        this.movieService = movieService;
        this.connection = connection;
    }

    @GetMapping()
    public String getMoviesPage(Model model) {

        model.addAttribute("movieDto", new MovieDto());
//        for(int i = 10000; i < 100001; i++) {
//            try {
//                String received = connection.apiConnection(i);
//                Mapper mapper = new Mapper();
//                Movie movie = mapper.mapToMovie(received);
//                movieService.save(movie);
//            } catch (Exception e) {
////            e.printStackTrace();
//            }
//        }
        List<Movie> list = movieService.findAll();
//        List<Movie> movies = new ArrayList<>();
//        movies.add(list.get(0));
//        movies.add(list.get(1));
        model.addAttribute("movies", list);

        return "moviesPage";
    }

    @PostMapping(params = "search")
    public String searchMovie(@RequestParam("name") String name, Model model, @ModelAttribute @Valid MovieDto movieDto, BindingResult bindingResult) {

//        if(bindingResult.hasErrors()) {
//            return "moviesPage";
//        }

        List<Movie> movies = movieService.search(name);
        model.addAttribute("movies", movies);

        return "moviesPage";
    }
}