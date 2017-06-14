package asw.project.restaurants.service;

import java.util.ArrayList;

public interface CityService {
	public ArrayList<String> getCityRestaurants(String city);	
	public String getSpecialty(String city, String restaurant);
}
