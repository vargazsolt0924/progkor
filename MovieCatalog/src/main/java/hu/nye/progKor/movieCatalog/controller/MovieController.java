package hu.nye.progKor.movieCatalog.controller;

import java.util.List;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import hu.nye.progKor.movieCatalog.request.MovieRequest;
import hu.nye.progKor.movieCatalog.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public MovieEntity saveMovie(@RequestBody @Valid MovieRequest movieRequest) {
        return movieService.saveMovie(movieRequest);
    }

    @GetMapping("/movies/{id}")
    public MovieEntity getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/movies/{id}")
    public MovieEntity updateMovie(@PathVariable("id") Long id, @RequestBody MovieRequest movieRequest) {
        return movieService.updateMovie(id, movieRequest);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovieById(id);
    }

    @GetMapping("/movies/movieRate/{movieRate}")
    public List<MovieEntity> getAllMovieByMovieRate(@PathVariable("movieRate") int movieRate) {
        return movieService.findAllMoviesByMovieRate(movieRate);
    }

    @GetMapping("/movies/releasedYear/{releasedYear}")
    public List<MovieEntity> findAllMoviesByReleasedYear(@PathVariable("releasedYear") int releasedYear) {
        return movieService.findAllMoviesByReleasedYear(releasedYear);
    }

    @GetMapping("/movies/movieType/{movieType}")
    public List<MovieEntity> findAllMoviesByMovieType(@PathVariable("movieType") String movieType) {
        return movieService.findAllMoviesByMovieType(movieType);
    }

    @GetMapping("/movies/lengthInSeconds/{lengthInSeconds}")
    public List<MovieEntity> findAllMoviesByLengthInSeconds(@PathVariable("lengthInSeconds") int lengthInSeconds) {
        return movieService.findAllMoviesByLengthInSeconds(lengthInSeconds);
    }
}