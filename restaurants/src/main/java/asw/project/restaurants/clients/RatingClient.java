package asw.project.restaurants.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ratings")
public interface RatingClient {
	@RequestMapping(value="/{city}/{restaurant}", method=RequestMethod.GET)
	public double getRating(@PathVariable(value = "city") String city, @PathVariable(value = "restaurant") String restaurant); 
}