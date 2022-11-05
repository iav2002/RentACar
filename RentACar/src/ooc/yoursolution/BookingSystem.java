/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author ignac
 */
public class BookingSystem implements BookingSystemInterface{

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
    
        String line = in.readLine(); //reading line
        int i = 0;  //line number
        String name = "";
        List<CarInterface> cars = new ArrayList<>(); //stores cars in list
        
        while (line != null){
            if( i == 0){
                name = line;    //name equals first lline
            }else{
                String [] data = line.split(":"); //split the line
                String make = data[0];
                int count = Integer.valueOf(data[2]);
                
                Car c = new Car();
                c.setMake(Make.valueOf(make)); //Ignacio, wasn't working becuase it was missing .valueOf()
                c.setCount(count);       //update the count
                cars.add(c);
            }
            i++;
            line = in.readLine();   //reading following line
        }    
            
            RentACar rentACar = new RentACar();
            rentACar.setCars(cars); //set car info
            rentACar.setName(name); //set the name
            
            return rentACar;
    }
    
} 

    
