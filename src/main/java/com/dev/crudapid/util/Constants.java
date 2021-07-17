package com.dev.crudapid.util;

public  class Constants {
	
	private static Constants constants = null;
	
	private Constants() {}
	 
	public static Constants getConstant() {
		if(constants ==null) {
			return new Constants();
		}
		return constants;
	}
	
	public final String URL = "jdbc:mysql://localhost:3306/cars";
	public final String ROOT = "root";
	public final String PASSWORD = "";
	
	
	public final int INDEX_ONE = 1;
	public final int INDEX_TWO = 2;
	public final int INDEX_TREE = 3;
	public final int INDEX_FOUR= 4;
	public final int INDEX_FIVE = 5;
	public final int INDEX_SIX = 6;
	
	
	
	public final String  INSERT_CAR_INFO = "insert into car_info (name,version,year) values (?,?,?)";
	public final String SEARCH_DATA = "select name , version , year  from car_info where id = ?";
	public final String DELETE_DATA = "DELETE FROM car_info WHERE id = ? ";
	public final String UPDATE_DATA = "UPDATE car_info SET name = ? , version = ? , year = ?  WHERE id = ? ";
}
