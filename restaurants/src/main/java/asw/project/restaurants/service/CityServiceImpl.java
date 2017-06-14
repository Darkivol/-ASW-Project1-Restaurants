package asw.project.restaurants.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import asw.project.restaurants.clients.CityClient; 

@Service 
public class CityServiceImpl implements CityService {
	private final Logger logger = Logger.getLogger("asw.project.restaurants.service"); 

	@Autowired 
	private CityClient cityClient;
	
	@HystrixCommand(fallbackMethod="getFallbackCityRestaurants")
	public ArrayList<String> getCityRestaurants(String city) {
		return cityClient.getCityRestaurants(city); 
	} 
	
	public ArrayList<String> getFallbackCityRestaurants(String city) {
		logger.info("getCityRestaurants(): using fallback city: empty list");
		return new ArrayList<>(); 
	}
	
	@HystrixCommand(fallbackMethod="getFallbackSpecialty")
	public String getSpecialty(String city, String restaurant) {
		return cityClient.getSpecialty(city, restaurant); 
	} 
	
	public String getFallbackSpecialty(String city, String restaurant) {
		logger.info("getSpecialty(): using fallback specialty: empty string");
		return null; 
	}
}
