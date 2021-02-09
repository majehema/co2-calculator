/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sustainabilityservices.co2calculator;


/**
 *
 * @author mary_
 */
public class Main {

    public static void main(String[] args) {
        Car.createCars();
        System.out.println(Car.calcEmition(args));
    }
    
}
