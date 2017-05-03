package asw.project.restaurants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate; 

@Controller
public class RestaurantsController {

	private final Logger logger = Logger.getLogger("asw.project.restaurants"); 

	@Value("${city.uri}") 
	private String cityUri;

	@Value("${rating.uri}") 
	private String ratingUri;
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/S/{city}")
	public @ResponseBody Map<String, Map<String, String>> getRestaurantsByCity(@PathVariable String city) {
		ArrayList<String> cityRestaurants = this.getCityRestaurants(city);
		
		Map<String, Map<String, String>> restaurants2ratings = new HashMap<>();
		
		for(String restaurant : cityRestaurants) {
			double rating = this.getRating(city, restaurant);
			Map<String, String> result = new HashMap<>();
			result.put("rating", String.valueOf(rating));
			result.put("name", restaurant);
			restaurants2ratings.put(UUID.randomUUID().toString(), result);
		}
		
		logger.info("getRestaurantsByCity(): " + restaurants2ratings);
		return restaurants2ratings; 
	}
	
	@RequestMapping("/S/{city}/{restaurant}")
	public @ResponseBody Map<String, String> getRestaurantInfo(@PathVariable String city, @PathVariable String restaurant) {
		ArrayList<String> specialty = this.getSpecialty(city, restaurant);
		double rating = this.getRating(city, restaurant);
		
		Map<String, String> result = new HashMap<>();
		result.put("specialty", specialty.get(0));
		result.put("rating", String.valueOf(rating));
		return result;
	}
	
	private ArrayList<String> getCityRestaurants(String city) {
		String uri = cityUri.concat('/' + city);
		return new RestTemplate().getForObject(uri, ArrayList.class);
	}
	
	private ArrayList<String> getSpecialty(String city, String restaurant) {
		String uri = cityUri.concat('/' + city + '/' + restaurant);
		return new RestTemplate().getForObject(uri, ArrayList.class);
	}
	
	private double getRating(String city, String restaurant) {
		String uri = ratingUri.concat('/' + city + '/' + restaurant);
		return new RestTemplate().getForObject(uri,Double.class);
	}
}
