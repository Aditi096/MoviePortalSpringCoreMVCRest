package com.cg.movie.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.beans.Movie;




public interface MovieDAO extends JpaRepository<Movie, Integer> {

}
