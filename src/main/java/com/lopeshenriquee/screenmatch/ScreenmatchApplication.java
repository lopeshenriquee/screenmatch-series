package com.lopeshenriquee.screenmatch;

import com.lopeshenriquee.screenmatch.model.DataEpisodes;
import com.lopeshenriquee.screenmatch.model.DataSeason;
import com.lopeshenriquee.screenmatch.model.DataSeries;
import com.lopeshenriquee.screenmatch.principal.Principal;
import com.lopeshenriquee.screenmatch.service.ConsumoAPI;
import com.lopeshenriquee.screenmatch.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showMenu();
	}
}
