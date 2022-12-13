package com.accenture.lkm.dao;

import java.util.Collection;

import com.accenture.lkm.bussiness.bean.CarBean;

public interface CarDAO {

	Collection<CarBean> getAllCars();

	CarBean getCarDetailsById(int id);

	Integer addCar(CarBean car);

	CarBean updateCar(CarBean car);

	CarBean carEmployee(int id);

}