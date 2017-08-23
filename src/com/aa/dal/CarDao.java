package com.aa.dal;

import java.util.List;

import com.rt.aa.Car;

public interface CarDao 
{	
	public String planet = "Earth";
	public List<Car> getCars();
	public int save(Car car);
	public int delete(int id);
	public Car getCar(int id);
	public int modify(Car car);
}
