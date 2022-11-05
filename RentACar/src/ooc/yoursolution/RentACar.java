/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author ignac
 */
public class RentACar implements RentACarInterface {
    //setting name and cars attributes
    private String name;
    private List<CarInterface> cars = new ArrayList<>();
    
    
    @Override
    public List<CarInterface> getCars() {   
        return cars;    //cars getter
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;   //cars setter
    }

    @Override
    public String getName() {
        return name;       //name getter

    }

    @Override
    public void setName(String name) {
        this.name = name;       //name setter
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        CarInterface car = new Car();
        for(CarInterface c: this.cars){
            if(c.getMake() == make){        //checking if it matches the given make
                car = c;
                break;
            }
        }
        boolean[] days = car.getAvailability().get(month); //get the availability
        //this condition is to avoid going beyond the length of array
        int length;
        if(day + lengthOfRent <= days.length){
            length = day + lengthOfRent;
        }else{
            length = days.length;
        }
        
        int i; //counter
        for(i = day; i < length; i++){
            //in case one day is not available, return false
            if(days[i] == false){
                return false;
            }
        }
        
        return true;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {

        return 0;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        
        
        return false;
        
        
    }

    @Override
    public int getNumberOfCars() {
        
        return 0;
        
    }
    
}
