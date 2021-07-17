package com.dev.crudapid.controller;

import java.sql.SQLException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.dev.crudapid.deo.CarController;
import com.dev.crudapid.modal.Car;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

   
 
    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String InsertInfo(Car car) throws SQLException {
    	
    	//Assign data
    	if(CarController.insertCarInfo(car)) {
    		return "succussfully added";
    	}
    	else {
    		return "something wrong";
    	}
    	
     
    	
    }
	@Path("/searchCar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Car searchCarbyId(Car car) throws SQLException {
		
		if(CarController.SearchCar(car) != null) {
			return CarController.SearchCar(car);
		}
		return null;
		
	}
	
	@Path("/delete/{id}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String DeleteCar(@PathParam("id") int id) throws SQLException {
		  
		  if(!CarController.deleteCar(id)) {
			  return "deleted"+id;
		  }
		  else {
			  return "not deleted"+id;
		  }	
	}
	
	@Path("/update")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Car UpdateCar(Car car) throws SQLException {
		  
	  if(car != null) {
		  if(CarController.updateCar(car) != null) {
			  return CarController.updateCar(car);
		  }
		  else {
			  return null;
		  }
		  
	  }
	  else {
		  return null;
	  }
}
	
	
	
}
