package co.cleverly.cleverlybakes;

import co.cleverly.cleverlybakes.enumiration.InStoreStatus;
import co.cleverly.cleverlybakes.model.BakeryItems;
import co.cleverly.cleverlybakes.repo.BakeryItemsRepo;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class CleverlyBakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleverlyBakesApplication.class, args);
	}

	@Bean
	CommandLineRunner run(BakeryItemsRepo itemsRepo){
		return args -> {
			itemsRepo.save(new BakeryItems(null, "LOAF1","Sweet",12,"http://localhost:8080/server/image/server1.png", InStoreStatus.ITEM_AVAILABLE));
			itemsRepo.save(new BakeryItems(null, "LOAF2","Sweet",12,"http://localhost:8080/server/image/server2.png", InStoreStatus.ITEM_AVAILABLE));
			itemsRepo.save(new BakeryItems(null, "LOAF3","Sweet",12,"http://localhost:8080/server/image/server3.png", InStoreStatus.ITEM_AVAILABLE));
			itemsRepo.save(new BakeryItems(null, "LOAF4","Sweet",12,"http://localhost:8080/server/image/server4.png", InStoreStatus.ITEM_NOT_AVAILABLE));
		};
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept",
				"Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type", "Accept", "Jwt-Token",
				"Authorization","Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter();
	}

}
