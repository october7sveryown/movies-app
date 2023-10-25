package dev.yash.moviesapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/allmovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(
                movieService.getAllMovies(),
                HttpStatus.OK
        );
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable("id") String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId),HttpStatus.OK);
    }
}
