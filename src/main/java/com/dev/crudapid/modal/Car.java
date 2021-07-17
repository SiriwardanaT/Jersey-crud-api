package com.dev.crudapid.modal;

public class Car {
	private int id;
	private String carname;
	private String version;
	private String  year;

	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
	public Car(int id, String carname, String version, String year) {
		super();
		this.id = id;
		this.carname = carname;
		this.version = version;
		this.year = year;
	}


	public Car(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Car(String carname, String version, String year) {
		super();
		this.carname = carname;
		this.version = version;
		this.year = year;
	}
	

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Car(String carname) {
		super();
		this.carname = carname;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}


	
	

}
