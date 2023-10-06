import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestingCustomerClass {
    @Test
    @DisplayName("Test Admin Search")
    public void testAdminSearch() {
        assertTrue(Admin.admin_Search("Vidur","2021364"));
    }
    

    @Test
    @DisplayName("Test Print Current Status Elite")
    //1
    public void testPrintCurrentStatusElite() {
        Customer customer = new Customer("meh", "1233");
       customer.setCurrent_status(2);
        String expectedOutput = "CURRENT STATUS: ELITE";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.printCurrent_status();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test Print Current Status Prime")
    public void testPrintCurrentStatusPrime() {
       Customer customer = new Customer("meh", "1233");
       customer.setCurrent_status(1);
        String expectedOutput = "CURRENT STATUS: PRIME";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.printCurrent_status();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test Print Current Status Normal")
    public void testPrintCurrentStatusNormal() {
       
        Customer customer = new Customer("meh", "1233");
        String expectedOutput = "CURRENT STATUS: NORMAL";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.printCurrent_status();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    //2
    @DisplayName("Test Reduce Wallet Amount Sufficient Funds")
    public void testReduceWalletAmtSufficientFunds(){
        Customer customer = new Customer("meh", "1233");
        // customer.setCurrent_status(0);
        // customer.setWallet_amt(1000);
        assertTrue(customer.reduceWallet_amt(500));
    }

    @Test
    @DisplayName("Test Reduce Wallet Amount Insufficient Funds")
    public void testReduceWalletAmtInsufficientFunds(){
        Customer customer = new Customer("meh", "1233");
        // customer.setCurrent_status(0);
        // customer.setWallet_amt(1000);
        assertFalse(customer.reduceWallet_amt(1500));
    }

    @Test
    @DisplayName("Test Delivery Fee Status 0")
    //3
    public void testDeliveryFee(){
        Customer customer = new Customer("meh", "1233");
        
        double fee = customer.delivery_fee(100);
        assertEquals(105, fee, 0.001);
        
    }

    @Test
    @DisplayName("Test Delivery Fee Status 1")
    public void testDeliveryFeeStatus1(){
        Customer customer = new Customer("meh", "1233");
        customer.setCurrent_status(1);
        double fee = customer.delivery_fee(100);
        assertEquals(102, fee, 0.001);
    }

    @Test
    @DisplayName("Test Delivery Fee Status 2")
    public void testDeliveryFeeStatus2(){
        Customer customer = new Customer("meh", "1233");
        customer.setCurrent_status(2);
        double fee = customer.delivery_fee(100);
        assertEquals(100, fee, 0.001);
    }
    @Test
    @DisplayName("Test Delivery Fee Status -1")
    public void testDeliveryFeeStatus_1(){
        Customer customer = new Customer("meh", "1233");
        customer.setCurrent_status(-1);
        double fee = customer.delivery_fee(100);
        assertEquals(100, fee, 0.001);
    }

    @Test
    @DisplayName("Test Delivery Status 0")
    //4
    public void testDelivery(){
        Customer customer = new Customer("meh", "1233");
        String expectedOutput = "Order placed. It will be delivered in 7-10 days.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.delivery();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test Delivery Status 1")
    public void testDelivery1(){
        Customer customer = new Customer("meh", "1233");
        customer.setCurrent_status(1);
        String expectedOutput = "Order placed. It will be delivered in 3-6 days.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.delivery();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test Delivery Status 2")
    public void testDelivery2(){
        Customer customer = new Customer("meh", "1233");
        customer.setCurrent_status(2);
        String expectedOutput = "Your order will be delivered within 2 days";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.delivery();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    
}
