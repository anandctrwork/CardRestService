package com.rt.aa;

public class Customer {
	int id;
	String name;
	String info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}
