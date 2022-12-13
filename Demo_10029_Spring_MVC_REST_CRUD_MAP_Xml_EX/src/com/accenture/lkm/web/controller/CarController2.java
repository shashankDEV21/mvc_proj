package com.accenture.lkm.web.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.bussiness.bean.CarBean;
import com.accenture.lkm.service.CarService;

//Use appropriate annotation 
//@RestController
public class CarController2 {

	//Use appropriate annotation
	//@Autowired
	private CarService carService;
	
	/*(url = "car/controller/getDetails", 
	 reqmethod = GET, 
	 produces = JSON)*/
	/*@RequestMapping(value="car/controller/getDetails",
			method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE )*/
	public ResponseEntity<List<CarBean>> getcarDetails() {
		List<CarBean> listcar = new ArrayList<CarBean>(carService.getAllCar());
		//return response status Ok and listcar;
		ResponseEntity<List<CarBean>> response =null;
		//response = new ResponseEntity<>(listcar, HttpStatus.OK);
		return response;
	}

	/*(url = "car/controller/getDetailsById/{id}", reqmethod = GET, 
			produces = JSON)*/
	public ResponseEntity<CarBean> getcarDetailBycarId(@PathVariable("id") int myId) {
		CarBean car = carService.getCarDetailsById(myId);

		if (car != null) {
			//return response status ok and car;
			return null;
		} else {
			//return response status NOT_FOUND and car;
			return null;
		}
	}

	/*(url = "/car/controller/addcar", reqmethod = POST, 
			consumes = JSON, produces = TEXT_HTML_url)*/
	// use appropriate annotation to read the body
	public ResponseEntity<String> addcar( CarBean car) {
		int count=carService.addCar(car);
		//return message: "Car added successfully with id:" + count, and status as: CREATED
		return null;
	}

	/*(url = "/car/controller/updatecar", reqmethod = PUT, 
			consumes = JSON, 
			produces = JSON)*/
	// use appropriate annotation to read the body
	public ResponseEntity<CarBean> updatecar(CarBean car) {
		if (carService.getCarDetailsById(car.getCarId()) == null) {
			CarBean car2 = null;
			//return response status INTERNAL_SERVER_ERROR and car2;
			return null;
		}
		CarBean updated = carService.updateCar(car);
		//return response status OK and updated car object;
		return null;
	}

	/*(url = "/car/controller/deletecar/{id}", reqmethod = DELETE,
	produces = JSON)*/
	public ResponseEntity<CarBean> deletecar(@PathVariable("id") int myId) {
		if (carService.getCarDetailsById(myId) == null) {
			CarBean car2 = null;
			//return response status INTERNAL_SERVER_ERROR and car2;
			return null;
		}
		CarBean car = carService.removeCar(myId);
		//return response status OK and car;
		return null;
	}
}