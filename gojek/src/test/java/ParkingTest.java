import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sony on 2/5/2017.
 */
public class ParkingTest {


    @org.junit.Test
     public void testEntry() throws Exception {
           System.out.println("before class");
    }

    @Test
    public void setup(){
        int numSlots = 3;
        Parking p = new Parking(numSlots);
        Assert.assertEquals(numSlots, p.slots.length);
    }

    @Test
    public void TestEntry() {
        System.out.println("Test entry");
        Parking p = new Parking(3);
        p.entry("KA01HH1234", "White");
        p.entry("KA01HH9999", "White");

        Assert.assertEquals(3, p.entry("KA01BB0001", "Black"));

        Assert.assertNotEquals(4, p.entry("KA01P333", "Black"));


    }

   @Test
    public void TestExit() {

       System.out.println("Test exit");
       Parking p = new Parking(3);
        p.entry("KA01HH1234", "White");
        p.entry("KA01HH9999", "White");
        p.entry("KA01BB0001", "Black");

        Assert.assertEquals(2, p.exit(2));

        Assert.assertNotEquals(4, p.exit(4));
    }

   @Test

    public  void TestSlot_number_for_registration_number(){
       Parking p = new Parking(3);
       p.entry("KA01HH1234", "White");
       p.entry("KA01HH9999", "White");
       p.entry("KA01BB0001", "Black");

       Assert.assertEquals(2, p.slot_number_for_registration_number("KA01HH9999"));
   }

    @Test
    public void TestSlot_numbers_for_cars_with_colour(){
      Parking p = new Parking(3);

        p.entry("KA01HH1234", "White");
        p.entry("KA01HH9999", "White");
        p.entry("KA01BB0001", "Black");

        Assert.assertEquals("3", p.slot_numbers_for_cars_with_colour("Black"));
    }

    @Test
    public void TestRegistration_numbers_for_cars_with_colour(){

        Parking p = new Parking(3);

        p.entry("KA01HH1234", "White");
        p.entry("KA01HH9999", "White");
        p.entry("KA01BB0001", "Black");

        Assert.assertEquals("KA01BB0001", p.registration_numbers_for_cars_with_colour("Black"));

        Assert.assertNotEquals("KA01HH9999", p.registration_numbers_for_cars_with_colour("Black"));
    }

    @org.junit.Test
    public void testExit() throws Exception {
        System.out.println("After class");
    }

}

