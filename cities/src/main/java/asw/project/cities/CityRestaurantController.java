package asw.project.cities;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "cities")
public class CityRestaurantController {
	
	private Map<String, String> restaurants;

	public Map<String, String> getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(Map<String, String> restaurants) {
		this.restaurants = restaurants;
	}
	
    @Value("${specialties}")  
	private String[] specialties;
	
	private final Logger logger = Logger.getLogger("asw.project.cities"); 

	
	@RequestMapping("/S1/{city}")
	public String[] ristoranti(@PathVariable String city){
		String[] result = (restaurants.get(city) == null) ? null : restaurants.get(city).split(",");
		return result;
	}
	
	@RequestMapping("/S1/{city}/{restaurant}")
	public List<String> getRestaurantSpecialty(@PathVariable String city, @PathVariable String restaurant) {
		return Arrays.asList(
				this.specialties[(int) (Math.round(Math.random()*(this.specialties.length - 1)))]
			   ); 
	}
}
