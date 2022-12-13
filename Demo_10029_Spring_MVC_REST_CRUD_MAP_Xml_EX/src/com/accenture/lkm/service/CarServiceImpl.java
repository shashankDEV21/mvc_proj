package com.accenture.lkm.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.bussiness.bean.CarBean;
import com.accenture.lkm.dao.CarDAO;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDAO carDAO;
	
	public Collection<CarBean> getAllCar(){
		return carDAO.getAllCars();			
	}
	
	public CarBean getCarDetailsById(int id){
		return carDAO.getCarDetailsById(id);
	}
	
	public Integer addCar(CarBean car){
		return carDAO.addCar(car);
	}
	
	public CarBean updateCar (CarBean car){
		return carDAO.updateCar(car);
	}
	
	public CarBean removeCar (int id){
		return carDAO.carEmployee(id);
	}
	
}
