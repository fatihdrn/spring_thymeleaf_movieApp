package com.fduran.MovieApp.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String name;

	private String type;

	private int year;

	private String description;

	private String media;

	private String language;

	@OneToMany
	@JoinColumn(name = "movie_id")
	private List<Actor> actors = new ArrayList<>();

	public Movie() {
	}

	public Movie(String name, String type, int year, String description, String media, String language,
			List<Actor> actors) {

		this.name = name;
		this.type = type;
		this.year = year;
		this.description = description;
		this.media = media;
		this.language = language;
		this.actors = actors;
	}

	public Movie(Integer id, String name, String type, int year, String description, String media, String language,
			List<Actor> actors) {

		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.description = description;
		this.media = media;
		this.language = language;
		this.actors = actors;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}
