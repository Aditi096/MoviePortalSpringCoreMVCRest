package com.cg.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.services.MovieServices;



@Controller
public class MovieServiceController {
	@Autowired
	MovieServices movieServices;
	@RequestMapping(value= {"/sayHello"},method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("Hello World From RESTImpl",HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/acceptMovieDetails"},method=RequestMethod.POST,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptMovieDetails(@ModelAttribute Movie movie){
		movie=movieServices.acceptMovieDetails(movie);
		return new ResponseEntity<>("Movie details successfully added movieId :-"+movie.getMovieId(),HttpStatus.OK);

	}
	@RequestMapping(value= {"/acceptSongDetails"},method=RequestMethod.POST,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptSongDetails(@RequestParam String songName,String singer, int movieId) throws MovieNotFoundException{
		Song song=movieServices.acceptSongDetails(songName,singer, movieId);
		return new ResponseEntity<>("Song details successfully added movieId :-"+song.getSongId(),HttpStatus.OK);

	}
	@RequestMapping(value= {"/getMovieDetails"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Movie> getMovieDetails(@RequestParam int movieId) throws MovieNotFoundException{
		Movie movie=movieServices.getMovieDetails(movieId);
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
	}
	@RequestMapping(value= {"/getSongDetails"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Song>> getSongDetails(@RequestParam int movieId) throws MovieNotFoundException{
		List<Song> songs=movieServices.getSongs(movieId);
		return new ResponseEntity<List<Song>>(songs,HttpStatus.OK);
	}
	@RequestMapping(value= {"/getAllMovies"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Movie>> getAllMovies() throws MovieNotFoundException{
		List<Movie> movies=movieServices.getAllMovies();
		return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
	}
	@RequestMapping(value= {"/removeMovie"},method=RequestMethod.DELETE,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> removeMovieDetails(@RequestParam int movieId) throws MovieNotFoundException{
		movieServices.removeMovieDetails(movieId);
		return new ResponseEntity<>("Movie successfully removed",HttpStatus.OK);

	}
}
