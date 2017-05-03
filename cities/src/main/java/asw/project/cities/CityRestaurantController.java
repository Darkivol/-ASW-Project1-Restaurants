package asw.project.cities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRestaurantController {
	
	@Value("${restaurants}")  
	private String[] restaurants;
	
	@Value("${specialties}")  
	private String[] specialties;
	
	private final Logger logger = Logger.getLogger("asw.project.cities"); 

	
	@RequestMapping("/{city}")
	public @ResponseBody String[] ristoranti(@PathVariable String city){
		Random rand = new Random();
		String[] result = {restaurants[rand.nextInt(restaurants.length)], 
							restaurants[rand.nextInt(restaurants.length)],
							restaurants[rand.nextInt(restaurants.length)]};
		return result;
	}
	
	@RequestMapping("/{city}/{restaurant}")
	public @ResponseBody List<String> getRestaurantSpecialty(@PathVariable String city, @PathVariable String restaurant) {
		return Arrays.asList(
				this.specialties[(int) (Math.round(Math.random()*(this.specialties.length - 1)))]
			   ); 
	}
}
