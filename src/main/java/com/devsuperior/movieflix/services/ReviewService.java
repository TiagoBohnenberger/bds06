package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private AuthService authService;

    @Autowired
    private MovieRepository movieRepository;

    public ReviewDTO createReview(ReviewDTO dto) {
        Review review = new Review();
        copyDtoToEntity(review, dto);
        review = repository.save(review);
        return new ReviewDTO(review);
    }

    private void copyDtoToEntity(Review entity, ReviewDTO dto) {
        entity.setMovie(movieRepository.getOne(dto.getId()));
        entity.setText(dto.getText());
        entity.setUser(authService.authenticated());
    }
}
