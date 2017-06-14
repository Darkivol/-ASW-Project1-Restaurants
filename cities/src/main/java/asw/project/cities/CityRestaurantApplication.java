package asw.project.cities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CityRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityRestaurantApplication.class, args);
	}

}
