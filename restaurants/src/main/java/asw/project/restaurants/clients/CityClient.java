package asw.project.restaurants.clients;

import java.util.ArrayList;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cities")
public interface CityClient {
	@RequestMapping(value="/{city}", method=RequestMethod.GET)
	public ArrayList<String> getCityRestaurants(@PathVariable(value = "city") String city);
	
	@RequestMapping(value="/{city}/{restaurant}", method=RequestMethod.GET)
	public String getSpecialty(@PathVariable(value = "city") String city, @PathVariable(value = "restaurant") String restaurant);
}
