package com.rarcos.real_estate.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rarcos.real_estate.models.House;
import com.rarcos.real_estate.repositories.HouseRepository;

@Service
public class HouseService {

	@Autowired
	private HouseRepository repository;

	public House addHouse(House e) {
		return repository.save(e);
	}

	public List<House> getAllHouses() {
		return repository.findAll();
	}

	public Optional<House> getHouseById(long id) {
		return repository.findById(id);
	}

	public Optional<House> updateHouse(House house, String fileName) {
		Optional<House> editHouse = repository.findById(house.getId());
		editHouse.ifPresent(t -> t.setProperty(house.getProperty()));
		editHouse.ifPresent(t -> t.setShortDescription(house.getShortDescription()));
		editHouse.ifPresent(t -> t.setPhone(house.getPhone()));
		editHouse.ifPresent(t -> t.setLongDescription(house.getLongDescription()));
		editHouse.ifPresent(t -> t.setPhoto(house.getPhoto()));
		editHouse.ifPresent(t -> repository.save(editHouse.get()));
		
	    return editHouse;
	}
	
	public void removeHouseById(long id) {
		repository.deleteById(id);
	}	

	@PostConstruct
	public void init() {
	}

}
