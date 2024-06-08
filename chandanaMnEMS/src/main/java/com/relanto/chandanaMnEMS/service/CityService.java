package com.relanto.chandanaMnEMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relanto.chandanaMnEMS.repository.CityRepository;
import com.relanto.chandanaMnEMS.entity.*;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityDetails) {
        City city = cityRepository.findById(id).orElse(null);
        if (city != null) {
            city.setCityName(cityDetails.getCityName());
            city.setCityCode(cityDetails.getCityCode());
            return cityRepository.save(city);
        }
        return null;
    }

    public boolean deleteCity(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        if (city != null) {
            cityRepository.delete(city);
            return true;
        }
        return false;
    }

    public List<City> searchCityByName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }
}
