package asw.project.restaurants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate; 

@RestController
public class RestaurantsController {

	private final Logger logger = Logger.getLogger("asw.project.restaurants"); 

	@Value("${city.uri}") 
	private String cityUri;

	@Value("${rating.uri}") 
	private String ratingUri;

	@RequestMapping("/{city}")
	public Map<String, Double> getRestaurantsByCity(@PathVariable String city) {
		ArrayList<String> cityRestaurants = (ArrayList<String>) this.getCityRestaurants(cityUri.concat('/' + city));
		
		Map<String, Double> restaurants2ratings = new HashMap<>();
		
		for(String restaurant : cityRestaurants) {
			double rating = this.getRating(ratingUri.concat('/' + city + '/' + restaurant));
			restaurants2ratings.put(restaurant, rating);
		}
		
		logger.info("getRestaurantsByCity(): " + restaurants2ratings);
		return restaurants2ratings; 
	}
	
	@RequestMapping("/{city}/{restaurant}")
	public String[] getRestaurantInfo(@PathVariable String city, @PathVariable String restaurant) {
		String specialty = (String) this.getCityRestaurants(cityUri.concat('/' + city + '/' + restaurant));
		double rating = this.getRating(ratingUri.concat('/' + city + '/' + restaurant));
		return new String[]{specialty, String.valueOf(rating)}; 
	}
	
	private Object getCityRestaurants(String uri) {
		return new RestTemplate().getForObject(uri, Object.class);
	}
	
	private double getRating(String uri) {
		return new RestTemplate().getForObject(uri,Double.class);
	}
	
}
