/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        CarInterface car = new Car();
        for(CarInterface c: this.cars){
            if(c.getMake() == make){
                car = c;
                break;
            }
        }
        //In case the car is available
        return car.getId();
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        //first, we check if it is available
        boolean available = this.checkAvailability(month, day, make, lengthOfRent);
        if(available == true){
            return true;
        }
        
        CarInterface car = new Car();
        int index = 0; //keeping track of which index car belongs to
        int i; //counter
        for (i = 0; i < this.cars.size(); i++){
            if(this.cars.get(i).getMake() == make){
                car = this.cars.get(i);
                index = i;
                break;
            }
        }
        
        //Map for getting the availability
        Map<Month, boolean[]> availability = car.getAvailability();
        boolean[] days = availability.get(month);   //getting the days of the month
        
        //boundary conditions
        int length;
        if (day + lengthOfRent <= days.length){
            length = day + lengthOfRent;
        }else{
            length = days.length;
        }
        
        for(int j = day; j < length; j++){
            car.book(month, j); //book for each day
        }
        
        this.cars.set(index, car);  //update the cars
        
        return true;
        
    }

    @Override
    public int getNumberOfCars() {
        int carNum = 0; //counter
        
        //adding the count while going through each object in the car list
        for(CarInterface c : this.cars){
            carNum += ((Car) c).getCount();
        }
        return carNum;
        
    }
    
}
