package asw.project.restaurants.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import asw.project.restaurants.clients.RatingClient;

import java.util.logging.Logger; 

@Service 
public class RatingServiceImpl implements RatingService {
	private final Logger logger = Logger.getLogger("asw.project.restaurants.service"); 

	@Autowired 
	private RatingClient ratingClient;
	
	@HystrixCommand(fallbackMethod="getFallbackRating")
	public double getRating(String city, String restaurant) {
		return ratingClient.getRating(city, restaurant); 
	} 
	
	public double getFallbackRating(String city, String restaurant) {
		logger.info("getRating(): using fallback rating: 0");
		return 0.0f; 
	}
}
