package asw.project.cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class CityRestaurantController {
	
	@Value("${restaurants}")  
	private HashMap<String, ArrayList<String>> restaurants;
	
	@Value("${specialties}")  
	private ArrayList<String> specialties;
	
	private final Logger logger = Logger.getLogger("asw.project.cities"); 

	@RequestMapping("/{city}")
	public ArrayList<String> getRestaurantsByCity(@PathVariable String city) {
		return this.restaurants.get(city.toLowerCase()); 
	}
	
	@RequestMapping("/{city}/{restaurant}")
	public String getRestaurantSpecialty(@PathVariable String city, @PathVariable String restaurant) {
		return this.specialties.get((int) (Math.round(Math.random()*(this.specialties.size() - 1)))); 
	}
}
