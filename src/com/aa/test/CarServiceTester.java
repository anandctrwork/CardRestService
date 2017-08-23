package com.aa.test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.rt.aa.Car;

public class CarServiceTester  {

   private Client client;
   private String REST_SERVICE_BASE_URL = "http://localhost:9090/MyCarRestDemo/rest/CarService";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
      CarServiceTester tester = new CarServiceTester();
      //initialize the tester
      tester.init();
      //test get all Cars Web Service Method
      tester.testGetAllCars();
      //test get Car Web Service Method 
      tester.testGetCar();
      //test update Car Web Service Method
      tester.testUpdateCar();
      //test add Car Web Service Method
      tester.testAddCar();
      //test delete Car Web Service Method
      tester.testDeleteCar();
   }
   //Test: Get list of all Cars
   //Test: Check if list is not empty
   private void testGetAllCars(){
      GenericType<List<Car>> list = new GenericType<List<Car>>() {};
      List<Car> Cars = client
         .target(REST_SERVICE_BASE_URL + "/list")
         .request(MediaType.APPLICATION_XML)
         .get(list);
      String result = PASS;
      if(Cars.isEmpty()){
         result = FAIL;
      }
      System.out.println("Test case name: testGetAllCars, Result: " + result );
   }
   //Test: Get Car of id 1
   //Test: Check if Car is same as sample Car
   private void testGetCar(){
      Car sampleCar = new Car();
      sampleCar.setId(700);

      Car Car = client
         .target(REST_SERVICE_BASE_URL)
         .path("/car/{Carid}")
         .resolveTemplate("Carid", 1)
         .request(MediaType.APPLICATION_XML)
         .get(Car.class);
      String result = FAIL;
      if(sampleCar != null && sampleCar.getId() == Car.getId()){
         result = PASS;
      }
      System.out.println("Test case name: testGetCar, Result: " + result );
   }
   //Test: Update Car of id 1
   //Test: Check if result is success XML.
   private void testUpdateCar(){
      Form form = new Form();
      form.param("id", "1");
      form.param("model", "abc");
      form.param("color", "xyz");
      form.param("year", "2017");
      form.param("price", "45000");

      String callResult = client
         .target(REST_SERVICE_BASE_URL)
         .request(MediaType.APPLICATION_XML)
         .put(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testUpdateCar, Result: " + result );
   }
   //Test: Add Car of id 2
   //Test: Check if result is success XML.
   private void testAddCar(){
      Form form = new Form();
      form.param("id", "2");
      form.param("model", "abc2");
      form.param("color", "xyz2");
      form.param("year", "20172");
      form.param("price", "450002");
      
      String callResult = client
         .target(REST_SERVICE_BASE_URL)
         .path("/add")
         .request(MediaType.APPLICATION_XML)
         .post(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
   
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testAddCar, Result: " + result );
   }
   //Test: Delete Car of id 2
   //Test: Check if result is success XML.
   private void testDeleteCar(){
      String callResult = client
         .target(REST_SERVICE_BASE_URL)
         .path("/{Carid}")
         .resolveTemplate("Carid", 2)
         .request(MediaType.APPLICATION_XML)
         .delete(String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testDeleteCar, Result: " + result );
   }
}