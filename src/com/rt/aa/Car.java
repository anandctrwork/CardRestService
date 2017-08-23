package com.rt.aa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car
{
	
	private int id;
	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	private String model;
	private String color;
	private int year;
	private int price;
	
	public int getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Car()
	{
		
	}

	public Car(int vin, String model, String color, int year, int price)
	{
		this.color = color;
		this.id = vin;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	
	@XmlElement	
	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	@XmlElement
	public void setYear(int miles) {
		this.year = miles;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}


}
