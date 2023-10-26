package dev.yash.moviesapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies/")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Map<String, String> request){
        return new ResponseEntity<>(
                reviewService.addReview(request.get("description"), request.get("imdbId")),
                HttpStatus.CREATED
        );
    }

}
