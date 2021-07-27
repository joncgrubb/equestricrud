package com.joncgrubb.equestricrud.equestricrud.services;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.joncgrubb.equestricrud.equestricrud.data.common.Gender;
import com.joncgrubb.equestricrud.equestricrud.data.entities.Horse;
import com.joncgrubb.equestricrud.equestricrud.data.interfaces.HorseInterface;
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
			System.out.println("*** Finding new horse object ***");
			Horse horse = horseRepository.findById(id).orElse(null);
			HorseInterface horseInterface = new HorseInterface();
			System.out.println("*** New horse object query completed ***");
			if (horse != null) {
				System.out.println("*** Horse not null ***");
				horseInterface.setId(horse.getId());
				horseInterface.setName(horse.getName());
				horseInterface.setEquibaselink(horse.getEquibaselink());
				horseInterface.setOwner(horse.getOwner());
				horseInterface.setTrainer(horse.getTrainer());
				horseInterface.setJockey(horse.getJockey());
				horseInterface.setGenderName(String.valueOf(horse.getGender()));
				horseInterface.setAge(String.valueOf(horse.getFoalYear()));
			}

			model.addAttribute("horse", horseInterface);
			return "horse";
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horses", method = RequestMethod.GET)
	public String horseList(Model model) {
		try {
			List<HorseInterface> horseInterfaceList = new ArrayList<HorseInterface>();
			List<Horse> horseList = horseRepository.findAll();

			for (Horse horse : horseList) {
				HorseInterface horseInterface = new HorseInterface();
				if (horse != null) {
					horseInterface.setId(horse.getId());
					horseInterface.setName(horse.getName());
					horseInterface.setEquibaselink(horse.getEquibaselink());
					horseInterface.setOwner(horse.getOwner());
					horseInterface.setTrainer(horse.getTrainer());
					horseInterface.setJockey(horse.getJockey());

					// Calculate age of the horse based on currently held thoroughbred age
					// conventions; Birth date will always be year of birth on January 1
					LocalDate now = LocalDate.now();
					int currentYear = now.getYear();
					LocalDate foalDate = LocalDate.of(horse.getFoalYear(), Month.JANUARY, 1);
					LocalDate currentDate = LocalDate.of(currentYear, Month.JANUARY, 1);
					int age = Period.between(foalDate, currentDate).getYears();
					String ageString = String.valueOf(age);

					horseInterface.setAge(ageString);

					// Assign displayed horse gender based on age and actual gender
					String horseGender = null;
					if (horse.getGender().equals(Gender.f) && age < 4) {
						horseGender = "Filly";
					} else if (horse.getGender().equals(Gender.f)) {
						horseGender = "Mare";
					} else if (horse.getGender().equals(Gender.m) && age < 4) {
						horseGender = "Colt";
					} else if (horse.getGender().equals(Gender.m)) {
						horseGender = "Horse";
					}

					horseInterface.setGenderName(horseGender);

					horseInterfaceList.add(horseInterface);
				}
			}

			model.addAttribute("horses", horseInterfaceList);
			return "horses";
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horses", method = RequestMethod.POST)
	public String horsesAdd(@RequestParam String name, @RequestParam Gender gender, @RequestParam int foalYear,
			@RequestParam String equibaselink, @RequestParam String owner, @RequestParam String trainer,
			@RequestParam String jockey, Model model) {
		try {
			// TODO change foalYear to Integer from LocalDate

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

			return "redirect:/horses";
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/horse/{id}", method = RequestMethod.POST)
	public String horseEdit(@RequestParam long id, @RequestParam String name, @RequestParam Gender genderName,
			@RequestParam int age, @RequestParam String equibaselink, @RequestParam String owner,
			@RequestParam String trainer, @RequestParam String jockey, Model model) {
		try {
			// TODO Change foalYear from LocalDate to Integer

			System.out.println("************ Horse ID: " + id);
			Horse horse = horseRepository.findById(id).get();
			horse.setName(name);
			horse.setGender(genderName);
			horse.setFoalYear(age);
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
