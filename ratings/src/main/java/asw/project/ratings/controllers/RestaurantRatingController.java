package asw.project.ratings.controllers;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantRatingController {
	
	private final Logger logger = Logger.getLogger("asw.project.ratings"); 

	/* Calcola casualmente una valutazione tra 0 e 5 di un ristorante che si trova in una citta' e lo ritorna all'oggetto chiamante.
	 * Il risultato e' un numero decimale (che viene pero' incapsulato in un oggetto JSON).
	 */
	@RequestMapping("/S2/{city}/{restaurant}")
	public double getRestaurantRating(@PathVariable String city, @PathVariable String restaurant) {
		double rating = (Math.random() * 5);
		logger.info("S2 getRestaurantRating(" + city + ", " + restaurant + "): " + rating);
		return rating; 
	}
}
