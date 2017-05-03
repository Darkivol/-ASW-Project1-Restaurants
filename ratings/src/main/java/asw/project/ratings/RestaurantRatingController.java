package asw.project.ratings;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantRatingController {
	
	private final Logger logger = Logger.getLogger("asw.project.ratings"); 

	@RequestMapping("/{city}/{restaurant}")
	public @ResponseBody double getRestaurantRating(@PathVariable String city, @PathVariable String restaurant) {
		return Math.floor((Math.random() * 5) * 10) / 10; 
	}
}
