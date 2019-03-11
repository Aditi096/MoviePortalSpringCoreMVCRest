package com.cg.movie.beans;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int movieId;
	private String movieName;
	private String movieDirector;
	private String editor;
	private String musicDirector;
	@JsonBackReference
	@OneToMany(mappedBy="movie", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer,Song> songs;
	public Movie() {}
	public Movie(int movieId, String movieName, String movieDirector, String editor, String musicDirector,
			Map<Integer, Song> songs) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.editor = editor;
		this.musicDirector = musicDirector;
		this.songs = songs;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getMusicDirector() {
		return musicDirector;
	}
	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}
	public Map<Integer, Song> getSongs() {
		return songs;
	}
	public void setSongs(Map<Integer, Song> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", editor=" + editor + ", musicDirector=" + musicDirector + ", songs=" + songs + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editor == null) ? 0 : editor.hashCode());
		result = prime * result + ((movieDirector == null) ? 0 : movieDirector.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((musicDirector == null) ? 0 : musicDirector.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (editor == null) {
			if (other.editor != null)
				return false;
		} else if (!editor.equals(other.editor))
			return false;
		if (movieDirector == null) {
			if (other.movieDirector != null)
				return false;
		} else if (!movieDirector.equals(other.movieDirector))
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (musicDirector == null) {
			if (other.musicDirector != null)
				return false;
		} else if (!musicDirector.equals(other.musicDirector))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}
	
}
