package asw.project.restaurants.controllers;

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

	/* URI del servizio S1, injectato da Spring sulla base del file YAML */
	@Value("${city.uri}") 
	private String cityUri;

	/* URI del servizio S2, injectato da Spring sulla base del file YAML */
	@Value("${rating.uri}") 
	private String ratingUri;
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	
	/* Recupera i ristoranti di una determinata citta', specificando per ognuno la valutazione.
	 * Viene recuperato per ogni ristorante la sua valutazione e i dati vengono inseriti in una mappa
	 * in cui la chiave e' un ID casuale (ma in un caso reale potrebbe essere l'ID del record nel database) e il valore e' un'altra mappa che contiene
	 * l'indicazione sul valore (ad esempio "name", "rating") ed il valore associato.
	 * Questa mappa viene convertita in un oggetto JSON dal controller grazie all'annotazione ResponseBody.
	 */
	@RequestMapping("/S/{city}")
	public @ResponseBody Map<String, Map<String, String>> getRestaurantsByCity(@PathVariable String city) {
		ArrayList<String> cityRestaurants = this.getCityRestaurants(city);
		
		Map<String, Map<String, String>> restaurants2ratings = new HashMap<>();
		
		if (cityRestaurants == null)
			return new HashMap<>();
		
		for(String restaurant : cityRestaurants) {
			double rating = this.getRating(city, restaurant);

			Map<String, String> result = new HashMap<>();
			result.put("rating", String.format("%.2f", rating));
			result.put("name", restaurant);
			restaurants2ratings.put(UUID.randomUUID().toString(), result);
		}
		
		logger.info("getRestaurantsByCity(" + city + "): " + restaurants2ratings);
		
		return restaurants2ratings; 
	}
	
	/* Recupera le informazioni del ristorante che si trova in una determinata citta'.
	 * Le informazioni comprendono la specialita' del ristorante e la sua valutazione.
	 * Viene recuperata la specialita' del ristorante e la sua valutazione e i valori vengono inseriti in una mappa
	 * in cui la chiave e' l'indicazione sul valore (ad esempio "specialty", "rating") ed il valore e' il dato associato.
	 * Questa mappa viene convertita in un oggetto JSON dal controller grazie all'annotazione ResponseBody.
	 */
	@RequestMapping("/S/{city}/{restaurant}")
	public @ResponseBody Map<String, String> getRestaurantInfo(@PathVariable String city, @PathVariable String restaurant) {
		String specialty = this.getSpecialty(city, restaurant);
		double rating = this.getRating(city, restaurant);
		
		Map<String, String> result = new HashMap<>();
		result.put("specialty", specialty);
		result.put("rating", String.format("%.2f", rating));
		
		logger.info("getRestaurantInfo(" + city + ", " + restaurant + "): " + result);
		
		return result;
	}
	
	/* Questi metodi effettuano chiamate REST ai servizi S1 ed S2, specificando di volta in volta
	 * i parametri necessari.
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<String> getCityRestaurants(String city) {
		return new RestTemplate().getForObject(cityUri, ArrayList.class, city, null);
	}
	
	private String getSpecialty(String city, String restaurant) {
		return new RestTemplate().getForObject(cityUri, String.class, city, restaurant);
	}
	
	private double getRating(String city, String restaurant) {
		return new RestTemplate().getForObject(ratingUri,Double.class, city, restaurant);
	}
}
