package com.joncgrubb.equestricrud.equestricrud.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.joncgrubb.equestricrud.equestricrud.data.common.Gender;
import com.joncgrubb.equestricrud.equestricrud.data.entities.Horse;
import com.joncgrubb.equestricrud.equestricrud.data.repositories.HorseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HorseService {

	@Autowired
	private HorseRepository horseRepository;

	@RequestMapping("/horse/{id}")
	public String horse(@PathVariable Long id, Model model) {
		try {
			// model.addAttribute("horse", horseRepository.findById(id));
			horseRepository.findById(id).ifPresent(o -> model.addAttribute("horse", o));

			return "horse";
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horses", method = RequestMethod.GET)
	public String horseList(Model model) {
		try {
			model.addAttribute("horses", horseRepository.findAll());

			return "horses";
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horses", method = RequestMethod.POST)
	public String horsesAdd(@RequestParam String name, @RequestParam Gender gender, @RequestParam String foalYear,
			@RequestParam String equibaselink, @RequestParam String owner, @RequestParam String trainer,
			@RequestParam String jockey, Model model) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(foalYear, formatter);

			Horse newHorse = new Horse();
			newHorse.setName(name);
			newHorse.setGender(gender);
			newHorse.setFoalYear(localDate);
			newHorse.setEquibaselink(equibaselink);
			newHorse.setOwner(owner);
			newHorse.setTrainer(trainer);
			newHorse.setJockey(jockey);

			horseRepository.save(newHorse);

			model.addAttribute("horse", newHorse);

			return "redirect:/horses";
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horse/{id}", method = RequestMethod.POST)
	public String horseEdit(@RequestParam long id, @RequestParam String name, @RequestParam Gender gender,
			@RequestParam LocalDate foalYear, @RequestParam String equibaselink, @RequestParam String owner,
			@RequestParam String trainer, @RequestParam String jockey, Model model) {
		try {
			System.out.println("************ Horse ID: " + id);
			Horse horse = horseRepository.findById(id).get();
			horse.setName(name);
			horse.setGender(gender);
			horse.setFoalYear(foalYear);
			horse.setEquibaselink(equibaselink);
			horse.setOwner(owner);
			horse.setTrainer(trainer);
			horse.setJockey(jockey);

			horseRepository.save(horse);

			model.addAttribute("horse", horse);

			return "redirect:/horse/" + horse.getId();
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horse/{id}", method = RequestMethod.DELETE)
	public String horseDelete(@RequestParam long id, Model model) {
		try {
			horseRepository.deleteById(id);

			return "redirect:/horse";
		} catch (Exception e) {
			throw e;
		}
	}
}
