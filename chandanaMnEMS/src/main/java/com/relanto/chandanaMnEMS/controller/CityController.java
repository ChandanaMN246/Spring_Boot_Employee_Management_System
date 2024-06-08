package com.relanto.chandanaMnEMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.relanto.chandanaMnEMS.entity.City;
import com.relanto.chandanaMnEMS.service.*;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    
    @GetMapping("/hellow")
	public String hellow (){
		return "Hello World!";
	}

    @GetMapping("/list-city")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/create-city")
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/update-city/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
        return cityService.updateCity(id, cityDetails);
    }

    @DeleteMapping("/delete-city/{id}")
    public boolean deleteCity(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }

    @GetMapping("/search/{cityName}")
    public List<City> searchCityByName(@PathVariable String cityName) {
        return cityService.searchCityByName(cityName);
    }
}
