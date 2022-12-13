package com.accenture.lkm.service;

import java.util.Collection;

import com.accenture.lkm.bussiness.bean.CarBean;

public interface CarService {

	Collection<CarBean> getAllCar();

	CarBean getCarDetailsById(int id);

	Integer addCar(CarBean car);

	CarBean updateCar(CarBean car);

	CarBean removeCar(int id);

}