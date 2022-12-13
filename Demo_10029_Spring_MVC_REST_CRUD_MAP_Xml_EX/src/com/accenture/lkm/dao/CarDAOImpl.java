package com.accenture.lkm.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.CarBean;

@Repository
public class CarDAOImpl implements CarDAO {
	
	static public Map<Integer, CarBean> mapOfCar = new LinkedHashMap<Integer, CarBean>();
	static int count=10004;
	static
	{
		mapOfCar.put(10001, new CarBean("Car1",10001,12345.6,1001));
		mapOfCar.put(10002, new CarBean("Car2",10002,12355.6,1002));
		mapOfCar.put(10003, new CarBean("Car3",10003,12445.6,1003));
	}
	
	public Collection<CarBean> getAllCars(){
		return mapOfCar.values();			
	}
	
	public CarBean getCarDetailsById(int id){
		return mapOfCar.get(id);
	}
	
	public Integer addCar(CarBean car){
		count++;
		car.setCarId(count);
		mapOfCar.put(count, car);
		return count;
	}
	
	public CarBean updateCar (CarBean car){
		mapOfCar.put(car.getCarId(), car);
		return car;
	}
	
	public CarBean carEmployee (int id){
		CarBean emp= mapOfCar.remove(id);
		return emp;
	}
	
}
