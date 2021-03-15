package com.fduran.MovieApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fduran.MovieApp.Entity.Actor;

import com.fduran.MovieApp.Service.ActorService;

@Controller
public class ActorController {

	@Autowired
	private ActorService actorService;

	@GetMapping("/actors")
	public String listActors(Model model) {

		List<Actor> listActors = actorService.findAll();
		model.addAttribute("listActors", listActors);
		return "actors";
	}

	@GetMapping("/actor/new")
	public String showActorForm(Model model) {
		model.addAttribute("actor", new Actor());

		return "actor-form";
	}

	@PostMapping("/actor/save")
	public String saveACtor(Actor actor) {
		actorService.save(actor);

		return "redirect:/actors";

	}

	@GetMapping("/actor/edit/{id}")
	public String showEditActorForm(@PathVariable("id") Integer id, Model model) {

		Actor actor = actorService.findById(id);

		model.addAttribute("actor", actor);
		return "actor-form";
	}

	@GetMapping("/actor/delete/{id}")
	public String showDeleteActorForm(@PathVariable("id") Integer id, Model model) {
		actorService.deleteById(id);
		return "redirect:/actors";
	}
}
