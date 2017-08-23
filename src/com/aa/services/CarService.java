package com.aa.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aa.dal.CarDao;
import com.aa.dal.CarDaoImpl;
import com.rt.aa.Car;

// Checked into GIT

@Path("/CarService")
public class CarService 
{
	
	private final static String SUCCESS = "<response>SUCCESS</response>";
	private final static String FAILURE = "<response>FAILURE</response>";
	
	CarDao cardao = new CarDaoImpl();
	
	@GET
	@Path("/car/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Car getCar(@PathParam("id") int id)
	{
		System.out.println("Hello World");
		return cardao.getCar(id);		
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> getCars()
	{
		return cardao.getCars();		
	}

	@POST
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String modifyCar(@FormParam("id") int id, 
			@FormParam("model") String model, 
			@FormParam("color") String color,
			@FormParam("year") int year , 
			@FormParam("price") int price)
	{
		Car car = new Car(id, model, color, year, price);
		if(cardao.modify(car) == id)
		{
			return SUCCESS;
		}
		else
		{
			return FAILURE;
		}		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String addCar(@FormParam("id") int id, 
			@FormParam("model") String model, 
			@FormParam("color") String color,
			@FormParam("year") int year , 
			@FormParam("price") int price)
	{
		Car car = new Car(id, model, color, year, price);
		if( cardao.save(car) == id)
			return SUCCESS;
		else
			return FAILURE;
	}
	
	
	@DELETE
	@Path("/delete/{id}")	
	@Produces(MediaType.APPLICATION_XML)
	public String removeCar(@PathParam("id") int id)
	{
	if(cardao.delete(id) == id)
		return SUCCESS;
	else
		return FAILURE;
	}

}
