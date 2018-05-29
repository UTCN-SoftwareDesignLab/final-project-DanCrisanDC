package moviesApp.service;

import moviesApp.dto.MovieDto;
import moviesApp.model.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);

    List<Movie> findAll();

    Movie findById(int id);

    List<Movie> search(String name);
}
