package com.cg.movie.services;

import java.util.List;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieNotFoundException;

public interface MovieServices {
	Movie acceptMovieDetails(Movie movie);
	Movie getMovieDetails(int movieId)throws MovieNotFoundException;
	List<Song> getSongs(int movieId)throws MovieNotFoundException;
	boolean removeMovieDetails(int movieId)throws MovieNotFoundException;
	//Song acceptSongDetails(Song song);
	Song acceptSongDetails(String songName, String singer, int movieId) throws MovieNotFoundException;
	List<Movie> getAllMovies();
}
