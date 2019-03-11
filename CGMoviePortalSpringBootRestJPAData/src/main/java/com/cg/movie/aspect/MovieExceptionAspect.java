package com.cg.movie.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.SongNotFoundException;
import com.cgmovie.responses.CustomResponse;


@ControllerAdvice
public class MovieExceptionAspect {
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<CustomResponse> handleMovieNotFoundException(Exception e) {
		CustomResponse response= new CustomResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(SongNotFoundException.class)
	public ResponseEntity<CustomResponse> handleSongNotFoundException(Exception e) {
		CustomResponse response= new CustomResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
