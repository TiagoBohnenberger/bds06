package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    @NotBlank(message = "Campo requerido")
    private String text;
    private long movieId;
    private UserDTO user;

    public ReviewDTO() {
    }

    public ReviewDTO(long id, String text, long movieId, UserDTO userDTO) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
        this.user = userDTO;
    }

    public ReviewDTO(Review review) {
        id = review.getId();
        text = review.getText();
        movieId = review.getMovie().getId();
        user = new UserDTO(review.getUser());
    }
}
