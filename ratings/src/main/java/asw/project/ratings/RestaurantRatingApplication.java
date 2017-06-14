package asw.project.ratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantRatingApplication.class, args);
	}

}
