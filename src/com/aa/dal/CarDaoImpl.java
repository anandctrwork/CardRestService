package com.aa.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rt.aa.Car;

public class CarDaoImpl implements CarDao {
	
	public static HashMap<Integer, Car> cars = new HashMap<Integer, Car>();

	@Override
	public List<Car> getCars() {
		// TODO Auto-generated method stub
		if(cars.isEmpty())
		{
			Car car = new Car(700,"BMW","GLASS",2020,544654);
			cars.put(car.getId(), car);
			car = new Car(1,"Audi","BLACK",2020,544654);
			cars.put(car.getId(), car);
		}
		return new ArrayList<Car>(cars.values());
	}

	@Override
	public int save(Car car) {
		cars.put(car.getId(), car);
		return car.getId();
	}

	@Override
	public int delete(int id) {
		cars.remove(id);
		return id;
	}

	@Override
	public Car getCar(int id) {
		Car x = cars.get(id);
		System.out.println(x);
		return x;
	}

	@Override
	public int modify(Car car) {
		cars.put(car.getId(), car);
		return car.getId();
	}

}
