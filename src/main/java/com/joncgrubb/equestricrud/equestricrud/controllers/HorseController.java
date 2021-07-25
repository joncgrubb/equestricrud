package com.joncgrubb.equestricrud.equestricrud.controllers;

import java.time.LocalDate;

import com.joncgrubb.equestricrud.equestricrud.data.common.Gender;
import com.joncgrubb.equestricrud.equestricrud.data.entities.Horse;
import com.joncgrubb.equestricrud.equestricrud.data.repositories.HorseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@SpringBootApplication
@Controller
public class HorseController {

	@Autowired
	HorseRepository horseRepository;

	@RequestMapping("/horse/{id}")
	public String horse(@PathVariable Long id, Model model) {
		model.addAttribute("horse", horseRepository.findById(id));

		return "horse";
	}

	@RequestMapping(value = "/horse", method = RequestMethod.GET)
	public String horseList(Model model) {
		model.addAttribute("horse", horseRepository.findAll());

		return "horse";
	}

	@RequestMapping(value = "/horse", method = RequestMethod.POST)
	public String horseAdd(@RequestParam String name, @RequestParam Gender gender, @RequestParam LocalDate foalYear,
			@RequestParam String equibaselink, @RequestParam String owner, @RequestParam String trainer,
			@RequestParam String jockey, Model model) {
				Horse newHorse = new Horse();
				newHorse.setName(name);
				newHorse.setGender(gender);
				newHorse.setFoalYear(foalYear);
				newHorse.setEquibaselink(equibaselink);
				newHorse.setOwner(owner);
				newHorse.setTrainer(trainer);
				newHorse.setJockey(jockey);

				horseRepository.save(newHorse);

				model.addAttribute("horse", newHorse);

				return "redirect:/horse/" + newHorse.getId();
	}

	public static void main(String[] args) {
		SpringApplication.run(HorseController.class, args);
	}

}
