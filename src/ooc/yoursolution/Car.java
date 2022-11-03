/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author ignac
 */
public class Car implements CarInterface{
    
    private Make make;
    private double rate;
    private int id;
    private Map<Month, boolean[]> availability;
    

    @Override
    public Map<Month, boolean[]> createAvailability() {
        
        this.availability = new HashMap<>();
        
        return availability;
         
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
        return availability;
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
        
    }

    @Override
    public boolean book(Month month, int day) {
        
    }
    
}
