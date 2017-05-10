package asw.project.cities.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "cities")
public class CityRestaurantController {
	/* Questa mappa viene inizializzata da Spring injectando i valori della mappa "restaurants" che si trova nel file YAML */
	private Map<String, List<String>> restaurants;
	
	/* Questa mappa viene inizializzata da Spring injectando i valori dell'array "specialties" che si trova nel file YAML */
	private List<String> specialties;
	
	private final Logger logger = Logger.getLogger("asw.project.cities"); 

	/* Recupera i ristoranti di una determinata citta' dalla mappa e li ritorna all'oggetto chiamante.
	 * Il risultato e' un array codificato in JSON.
	 */
	@RequestMapping("/S1/{city}")
	public List<String> getRestaurantsByCity(@PathVariable String city) {
		List<String> restaurantsByCity = restaurants.get(city);
		logger.info("S1 getRestaurantsByCity(" + city + "): " + restaurantsByCity);
		return restaurantsByCity;
	}
	
	/*
	 * Recupera casualmente una specialita' di un ristorante che si trova in una citta' e la ritorna all'oggetto chiamante.
	 * Il risultato e' una stringa.
	 */
	@RequestMapping("/S1/{city}/{restaurant}")
	public String getRestaurantSpecialty(@PathVariable String city, @PathVariable String restaurant) {
		Collections.shuffle(specialties);
		String specialty = specialties.get(0);
		logger.info("S1 getRestaurantSpecialty(" + city + ", " + restaurant + "): " + specialty);
		return specialty; 
	}
	
	/* Getter e Setter per abilitare il dependency injection di Spring */
	public Map<String, List<String>> getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(Map<String, List<String>> restaurants) {
		this.restaurants = restaurants;
	}
	
	public List<String> getSpecialties() {
		return specialties;
	}
	
	public void setSpecialties(List<String> specialties) {
		this.specialties = specialties;
	}
}
