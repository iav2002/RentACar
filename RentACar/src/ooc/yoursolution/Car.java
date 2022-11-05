/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/***
 * @author ignac
 */
public class Car implements CarInterface{
    
    private Make make;
    private double rate;
    private int id; // cars 
    private int count; //number of cars
    private Map<Month, boolean[]> availability;
    
    public Car(){
        this.availability = new HashMap<>(); //intialize the HashMap
        this.createAvailability(); // initialize the availability of the cars
    }
   
    @Override
    public Map<Month, boolean[]> createAvailability() {
    
        this.availability = new HashMap<>(); // new hashmap

        for(Month month: Month.values()){
            boolean[] days = new boolean[month.getNumberOfDays()]; // create an array equivalent to the number of days
            Arrays.fill(days, true); // initialize set available in all days
         this.availability.put(month, days);
        }
            return this.availability;        
    }

    @Override
    public Make getMake() {       
        return make;
    }

    @Override
    public void setMake(Make make) {        
        this.make = make;      
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;        
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {                      
        return this.availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {     
        return this.availability.get(month)[day];      
    }

    @Override
    public boolean book(Month month, int day) {
       
        boolean available = this.isAvailable(month, day); //to check if is booked already
       //if not, we can book
        if(available){ 
            boolean[] days = this.availability.get(month); //get the days array
            days[day] = false;
            this.availability.put(month, days);
            return true;
        }
        return false; // is already booked
    }
    
    public int getCount(){ 
    //helper method to get number of cars
    //to be used in bookingSystems Bernardo
    return this.count;
    }
        
    public void setCount(int count){
    //helper method to set total number of cars
    //to be used in bookingSystems Bernardo
        this.count = count;
    }
}
