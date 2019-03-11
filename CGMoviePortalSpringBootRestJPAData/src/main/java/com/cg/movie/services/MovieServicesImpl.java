package com.cg.movie.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.daoservices.MovieDAO;
import com.cg.movie.daoservices.SongDAO;
import com.cg.movie.exceptions.MovieNotFoundException;
@Component("movieServices")
public class MovieServicesImpl implements MovieServices {
	@Autowired
	public MovieDAO movieDao;
	@Autowired
	public SongDAO songDao;
	@Override
	public Movie acceptMovieDetails(Movie movie) {
		return movieDao.save(movie);
	}
	@Override
	public Song acceptSongDetails(String songName,String singer, int movieId) throws MovieNotFoundException {
		Movie movie=getMovieDetails(movieId);
		Song song=new Song(songName, singer, movie);
		song=songDao.save(song);
		return song;
	}

	@Override
	public Movie getMovieDetails(int movieId) throws MovieNotFoundException {
		return movieDao.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie Details not found for movieId : "+movieId));
	}

	@Override
	public boolean removeMovieDetails(int movieId) throws MovieNotFoundException {
		movieDao.delete(getMovieDetails(movieId));
		return true;
	}
	@Override
	public List<Song> getSongs(int movieId) throws MovieNotFoundException {
		Movie movie=movieDao.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie Details not found for movieId : "+movieId));
		List<Song> songs=new ArrayList<Song>(movie.getSongs().values());
		return songs;
	}
	@Override
	public List<Movie> getAllMovies() {
		return movieDao.findAll();
	}

}
