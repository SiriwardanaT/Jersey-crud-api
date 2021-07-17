package com.dev.crudapid.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dev.crudapid.modal.Car;
import com.dev.crudapid.util.Constants;
import com.dev.crudapid.util.DatabaseConnection;
import com.mysql.cj.xdevapi.PreparableStatement;

public class CarController {

	//add car
	public static boolean insertCarInfo(Car car) throws SQLException {
		
		DatabaseConnection db = new DatabaseConnection();
		Connection con = db.getConnection();
		String query = Constants.getConstant().INSERT_CAR_INFO;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		
		preparedStatement.setString(Constants.getConstant().INDEX_ONE,car.getCarname());
		preparedStatement.setString(Constants.getConstant().INDEX_TWO,car.getVersion());
		preparedStatement.setString(Constants.getConstant().INDEX_TREE,car.getYear());
		
		if(preparedStatement.execute()) {
			return false;
		}
		else {
			return true;
		}
	
		
		
	}
	//search car
	public static  Car SearchCar(Car cars) throws SQLException {
		
		DatabaseConnection db = new DatabaseConnection();
		Connection con = db.getConnection();
		
		String query_getdata = Constants.getConstant().SEARCH_DATA;
		Car car = null;
		PreparedStatement preparedStatement = con.prepareStatement(query_getdata);
		
		preparedStatement.setInt(Constants.getConstant().INDEX_ONE,cars.getId());
		
		ResultSet rs  =  preparedStatement.executeQuery();
		//System.out.println(rs);
		while(rs.next()) {
			 String name = rs.getString(Constants.getConstant().INDEX_ONE);
			 String version = rs.getString(Constants.getConstant().INDEX_TWO);
			 String year = rs.getString(Constants.getConstant().INDEX_TREE);
			 
			 car = new Car(name,version,year);
			
		}
		
		return car;
			
	}
	
	//delete car
	public static boolean deleteCar(int id) throws SQLException {
		DatabaseConnection db = new DatabaseConnection();
		Connection con = db.getConnection();
		
		
		String delete_query = Constants.getConstant().DELETE_DATA;
		
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
		preparedStatement.setInt(Constants.getConstant().INDEX_ONE, id);
		boolean isDeleted = preparedStatement.execute();
		
		return isDeleted;
		
		
		
	}
	public static Car updateCar(Car car) throws SQLException {
		DatabaseConnection db = new DatabaseConnection();
		Connection con = db.getConnection();
		
		
		String update_query = Constants.getConstant().UPDATE_DATA;
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
		preparedStatement.setString(Constants.getConstant().INDEX_ONE,car.getCarname());
		preparedStatement.setString(Constants.getConstant().INDEX_TWO,car.getVersion());
		preparedStatement.setString(Constants.getConstant().INDEX_TREE,car.getYear());
		preparedStatement.setInt(Constants.getConstant().INDEX_FOUR,car.getId());
		
	
		if(preparedStatement.executeUpdate() > 0) {
			return SearchCar(car);
		}
		else {
			return null;
		}
		
		
	}



}
