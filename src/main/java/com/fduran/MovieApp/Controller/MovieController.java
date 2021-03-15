package com.fduran.MovieApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fduran.MovieApp.Entity.Actor;
import com.fduran.MovieApp.Entity.Movie;

import com.fduran.MovieApp.Service.ActorService;
import com.fduran.MovieApp.Service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private ActorService actorService;

	@GetMapping("/movie/new")
	public String showCreateNewMovieForm(Model model) {

		List<Actor> listActors = actorService.findAll();

		model.addAttribute("listActors", listActors);
		model.addAttribute("movie", new Movie());

		return "movie_form";
	}

	@PostMapping("/movie/save")
	public String saveMovie(Movie movie) {
		movieService.save(movie);

		return "redirect:/movies";
	}

	@GetMapping("/moviesSorted")
	public String listMovies(Model model) {

		List<Movie> listMovies = movieService.findAllSorting();
		model.addAttribute("listMovies", listMovies);

		return "movies";
	}

	@GetMapping("/movies")
	public String listMovies(Model model, String keyword) {

		if (keyword != null) {

			model.addAttribute("listMovies", movieService.findByKeyword(keyword));
		} else {

			List<Movie> listMovies = movieService.findAll();
			model.addAttribute("listMovies", listMovies);
		}

		return "movies";
	}

	@GetMapping("/movie/edit/{id}")
	public String showEditMovieForm(@PathVariable("id") Integer id, Model model) {

		Movie movie = movieService.findById(id);
		List<Actor> listActors = actorService.findAll();

		model.addAttribute("listActors", listActors);
		model.addAttribute("movie", movie);
		return "movie_form";
	}

	@GetMapping("/movie/delete/{id}")
	public String showDeleteMovieForm(@PathVariable("id") Integer id, Model model) {
		movieService.deleteById(id);
		return "redirect:/movies";
	}
}
