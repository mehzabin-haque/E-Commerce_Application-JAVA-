
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EcommerceTesting  {

    @Test
    //1
    public void testCustomerSearch() {
        assertTrue(Store.customer_Search("Vidur","2021364"));
    }

    @Test
    //1
    public void testCategorySearch() {
        assertTrue(Store.category_Search(1));
    }

    
    //3
    @Test
    public void testProdSeaProductExists() {
        // Create an instance of your class or access the function through an instance
       Store prod = new Store();
        
        // Create a test product ID that exists in the Category_product map
        double testProductId = 12345.0;

        // Call the prod_sea function with the test product ID
        boolean result = prod.prod_sea(testProductId);

        // Assert that the function returns true, indicating that the product was found
        assertTrue(result);
    }

    @Test
    public void testProdSeaProductNotExists() {
        // Create an instance of your class or access the function through an instance
        Store prod = new Store();

        // Create a test product ID that does not exist in the Category_product map
        double testProductId = 99999.0;

        // Call the prod_sea function with the test product ID
        boolean result = prod.prod_sea(testProductId);

        // Assert that the function returns false, indicating that the product was not found
        assertFalse(result);
    }

   @Test
   //4
    public void testDelivery() {
        // Create an instance of the class that contains the delivery function
        Customer order = new Customer(null, null);

        // Test case 1: Current status is 0
        order.setCurrent_status(0);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        order.delivery();
        assertEquals("Order placed. It will be delivered in 7-10 days.\n", outContent.toString());

        // Test case 2: Current status is 1
        order.setCurrent_status(1);
        outContent.reset();
        order.delivery();
        assertEquals("Order placed. It will be delivered in 3-6 days.\n", outContent.toString());

        // Test case 3: Current status is something else (e.g., 2)
        order.setCurrent_status(2);
        outContent.reset();
        order.delivery();
        assertEquals("Your order will be delivered within 2 days\n", outContent.toString());

        // Reset System.out to its original state
        System.setOut(System.out);
    }

    @Test
    //5
    public void testDeliveryFee() {
        // Create an instance of the class that contains the delivery_fee function
        Customer order = new Customer(null, null);

        // Test case 1: Current status is 0, total_mrp is 1000
        order.setCurrent_status(0);
        double fee1 = order.delivery_fee(1000.0);
        assertEquals(150.0, fee1, 0.01);  // Allow a small margin of error for double comparisons

        // Test case 2: Current status is 1, total_mrp is 2000
        order.setCurrent_status(1);
        double fee2 = order.delivery_fee(2000.0);
        assertEquals(140.0, fee2, 0.01);

        // Test case 3: Current status is something else (e.g., 2), total_mrp is 1500
        order.setCurrent_status(2);
        double fee3 = order.delivery_fee(1500.0);
        assertEquals(100.0, fee3, 0.01);
    }


    @Test
    //6
    public void testPrintCurrentStatusNormal() {
        Customer customer = new Customer("testuser", "testpassword");
        customer.setCurrent_status(0);
        
        // Redirect System.out print output for testing purposes
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        customer.printCurrent_status();
        
        assertEquals("CURRENT STATUS: NORMAL\n", outContent.toString());
        
        // Reset System.out to its original state
        System.setOut(System.out);
    }

    @Test
    //7
    public void testPrintCurrentStatusPrime() {
        Customer customer = new Customer("testuser", "testpassword");
        customer.setCurrent_status(1);

        // Redirect System.out print output for testing purposes
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        customer.printCurrent_status();

        assertEquals("CURRENT STATUS: PRIME\n", outContent.toString());

        // Reset System.out to its original state
        System.setOut(System.out);
    }

    @Test
    //8
    public void testPrintCurrentStatusElite() {
        Customer customer = new Customer("testuser", "testpassword");
        customer.setCurrent_status(2);

        // Redirect System.out print output for testing purposes
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        customer.printCurrent_status();

        assertEquals("CURRENT STATUS: ELITE\n", outContent.toString());

        // Reset System.out to its original state
        System.setOut(System.out);
    }

    @Test
    public void testReduceWalletAmtSufficientFunds() {
        Customer customer = new Customer("testuser", "testpassword");
        customer.reduceWallet_amt(1000.0);

        // Test reducing an amount within the wallet balance
        boolean result = customer.reduceWallet_amt(500.0);
        assertTrue(result);
        assertEquals(500.0, customer.getWallet_amt(), 0.01);  // Ensure wallet balance is updated correctly
    }

    @Test
    public void testReduceWalletAmtInsufficientFunds() {
        Customer customer = new Customer("testuser", "testpassword");
        customer.reduceWallet_amt(100.0);

        // Test reducing an amount that exceeds the wallet balance
        boolean result = customer.reduceWallet_amt(200.0);
        assertFalse(result);  // Wallet balance is insufficient, so should return false
        assertEquals(100.0, customer.getWallet_amt(), 0.01);  // Wallet balance should remain unchanged
    }

    @Test
    public void testReduceWalletAmtExactFunds() {
        Customer customer = new Customer("testuser", "testpassword");
        customer.reduceWallet_amt(300.0);

        // Test reducing an amount equal to the wallet balance
        boolean result = customer.reduceWallet_amt(300.0);
        assertTrue(result);  // Wallet balance is sufficient, so should return true
        assertEquals(0.0, customer.getWallet_amt(), 0.01);  // Wallet balance should become zero
    }

}

