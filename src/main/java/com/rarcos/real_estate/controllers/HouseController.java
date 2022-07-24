package com.rarcos.real_estate.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rarcos.real_estate.models.House;
import com.rarcos.real_estate.services.HouseService;

@RestController
@CrossOrigin
public class HouseController {

	@Autowired
    private HouseService houseService;

    @RequestMapping(value = "/houses", method = RequestMethod.GET)
    public ResponseEntity<House> list() {
        List<House> house = houseService.getAllHouses();
        return new ResponseEntity(house, HttpStatus.OK);
    }

    @RequestMapping(value = "/houses/{id}", method = RequestMethod.GET)
    public ResponseEntity<House> userById(@PathVariable(value = "id") long id) {
    	Optional<House> house = houseService.getHouseById(id);
        return new ResponseEntity(house, HttpStatus.OK);
    }

    @RequestMapping(value = "/houses/new", method = RequestMethod.POST)
    public ResponseEntity<House> create(@Valid @ModelAttribute House house) {
        House houseCreated = houseService.addHouse(house);
        return new ResponseEntity(houseCreated, HttpStatus.CREATED);
    }
	
    @RequestMapping(value = "/houses/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<House> edit(@PathVariable(value = "id") long id, @Valid @ModelAttribute House house) {
        Optional<House> houseCreated = houseService.updateHouse(house, "");
        return new ResponseEntity(houseCreated, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/houses/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<House> delete(@PathVariable(value = "id") long id) {
        houseService.removeHouseById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
