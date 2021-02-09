package Java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sustainabilityservices.co2calculator.Car;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author mary_
 */
public class Tests {
    
    @Before
    public void createCars(){
        Car.createCars();
    }
    
    @Test
    public void negativeDistance() {
        Car tester = new Car();
        Assert.assertEquals("Invalid distance.", tester.calcEmition("--transportation-method medium-diesel-car --distance -15 --unit-of-distance km"));
    }

    @Test
    public void calculatingKmKg() {
        Car tester = new Car();
        Assert.assertEquals("Your trip caused 2.6kg of CO2-equivalent.", tester.calcEmition("--transportation-method medium-diesel-car --distance 15 --unit-of-distance km"));
    }

    @Test
    public void calculatingWithoutUnit() {
        Car tester = new Car();
        Assert.assertEquals("Your trip caused 507.7kg of CO2-equivalent.", tester.calcEmition("--distance 1800.5 --transportation-method large-petrol-car"));
    }
    
    @Test
    public void calculatingWithUnitG() {
        Car tester = new Car();
        Assert.assertEquals("Your trip caused 87g of CO2-equivalent.", tester.calcEmition("--transportation-method train --distance 14500 --unit-of-distance m --output g"));
    }
    
    @Test
    public void calculatingWithUnitKg() {
        Car tester = new Car();
        Assert.assertEquals("Your trip caused 0.1kg of CO2-equivalent.", tester.calcEmition("--transportation-method train --distance 14500 --unit-of-distance m --output kg"));
    }
    
    @Test
    public void calculatingWithEqual() {
        Car tester = new Car();
        Assert.assertEquals("Your trip caused 2.6kg of CO2-equivalent.", tester.calcEmition("--unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car"));
    }
}