package com.joncgrubb.equestricrud;

// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.util.LinkedList;
// import java.util.List;

// import com.joncgrubb.equestricrud.equestricrud.data.entities.Horse;
import com.joncgrubb.equestricrud.equestricrud.data.repositories.HorseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.joncgrubb.equestricrud.equestricrud.data.common.Gender;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    HorseRepository horseRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // String date = "2021-07-25";

        // LocalDate dateFormatted = LocalDate.parse(date, formatter);

        // List<Horse> horses = new LinkedList<Horse>();
        // horses.add(new Horse("Ain't No Elmers", Gender.f, dateFormatted, "https://www.equibase.com/profiles/Results.cfm?type=Horse&refno=10265697&registry=T&rbt=TB", "John Kerber", "Bret Calhoun", "Adam Beschizza"));
        // horses.add(new Horse("Reagan's Edge", Gender.f, dateFormatted, "https://www.equibase.com/profiles/Results.cfm?type=Horse&refno=10256377&registry=T&rbt=TB", "Lael Stables", "Cherie DeVaux", "Jose Lescano"));
        // horses.add(new Horse("Sadie Lady", Gender.m, dateFormatted, "https://www.equibase.com/profiles/Results.cfm?type=Horse&refno=10105842&registry=T&rbt=TB", "Dennis Narlinger", "Rob Atras", "Jose Ortiz"));
        // horses.add(new Horse("Lake Avenue", Gender.f, dateFormatted, "https://www.equibase.com/profiles/Results.cfm?type=Horse&refno=10259239&registry=T&rbt=TB", "Godolphin, LLC", "William Mott", "Junior Alvarado"));
        // horseRepository.saveAll(horses);
    }
}