package com.fduran.MovieApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private String name;
	@Column(length = 45, nullable = false)
	private String surname;
	@Column(length = 45, nullable = false, unique = true)
	private String role;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	public Actor() {

	}

	public Actor(String name, String surname, String role, Movie movie) {

		this.name = name;
		this.surname = surname;
		this.role = role;
		this.movie = movie;
	}

	public Actor(Integer id, String name, String surname, String role, Movie movie) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.movie = movie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

}
