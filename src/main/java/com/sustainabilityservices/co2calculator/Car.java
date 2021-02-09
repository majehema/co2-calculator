/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sustainabilityservices.co2calculator;

import java.util.HashMap;

/**
 *
 * @author mary_
 */
public class Car {
    //CO2 gr per passenger per km
    static HashMap<String, Integer> carsEmition;
    
    public static void createCars() {
        carsEmition = new HashMap<>();
        carsEmition.put("small-diesel-car", 142);
        carsEmition.put("small-petrol-car", 154);
        carsEmition.put("small-plugin-hybrid-car", 73);
        carsEmition.put("small-electric-car", 50);
        carsEmition.put("medium-diesel-car", 171);
        carsEmition.put("medium-petrol-car", 192);
        carsEmition.put("medium-plugin-hybrid-car", 110);
        carsEmition.put("medium-electric-car", 58);
        carsEmition.put("large-diesel-car", 209);
        carsEmition.put("large-petrol-car", 282);
        carsEmition.put("large-plugin-hybrid-car", 126);
        carsEmition.put("large-electric-car", 73);
        carsEmition.put("bus", 27);
        carsEmition.put("train", 6);
    }
    
    public static String calcEmition(String args) {
        return calcEmition(args.split(" "));
    }
    
    public static String calcEmition(String[] args) {
        String transpMethod;
        Double distance = 0.0, totalCo2Emision;
        Integer carEmition = 0;
        String unitDistance = "km"; 
        String output = "kg";
        
        for (int i = 0; i < args.length; i++) {
            String[] arguments = args[i].split("=");
            switch (arguments[0]){
                case "--distance":
                    try {
                        if (arguments.length>1) {
                            distance = Double.valueOf(arguments[1]);
                        } else {
                            distance = Double.valueOf(args[i+1]);
                            i++;
                        }
                        if (distance < 0) {
                            return "Invalid distance.";
                        }
                    } catch (NumberFormatException e) {
                        return (e.toString());
                    }
                    break;

                case "--transportation-method":
                    if (arguments.length>1){
                        transpMethod = arguments[1];
                    } else {
                        transpMethod = args[i+1];
                        i++;
                    }
                    if (carsEmition.containsKey(transpMethod)){
                        carEmition = carsEmition.get(transpMethod);
                    } else {
                        return "The transportation method doesn't exist.";
                    }
                    
                    break;
                    
                case "--unit-of-distance":
                    if (arguments.length>1){
                        unitDistance = arguments[1].toLowerCase();
                    } else {
                        unitDistance = args[i+1].toLowerCase();
                        i++;
                    }
                    if (!unitDistance.equals("km") && !unitDistance.equals("m")){
                        return "The value of unit of distance is invalid";
                    }
                    break;
                    
                case "--output":
                    if (arguments.length>1){
                        output = arguments[1].toLowerCase();
                    } else {
                        output = args[i+1].toLowerCase();
                        i++;
                    }
                    if (!output.equals("g") && !output.equals("kg")){
                        return "The value of output is invalid";
                    }
                    break;
                    
                default:
                    return "Argument " + arguments[0] + " is invalid";
            }     
        }
        distance = unitDistance.equals("m") ? distance/1000: unitDistance.equals("km") ? distance : 0;
        totalCo2Emision = output.equals("g")? distance*carEmition : (distance*carEmition)/1000;
        return "Your trip caused " + 
                (String.format(output.equals("g")? "%.0f":"%.1f", totalCo2Emision)) + 
                output + " of CO2-equivalent.";
    }
}
