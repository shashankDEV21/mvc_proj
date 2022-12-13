package com.accenture.lkm.bussiness.bean;

//@XmlRootElement
public class CarBean {
	private String carName;
	private Integer carId;
	private double price;
	private Integer carEngineNumber;

	public CarBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarBean(String carName, Integer carId, double price,
			Integer carEngineNumber) {
		super();
		this.carName = carName;
		this.carId = carId;
		this.price = price;
		this.carEngineNumber = carEngineNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getCarEngineNumber() {
		return carEngineNumber;
	}

	public void setCarEngineNumber(Integer carEngineNumber) {
		this.carEngineNumber = carEngineNumber;
	}

}