
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TestingStoreClass {

    @Test
    @DisplayName("Test Category Search Returns True For Existing Category")
    // 1
    public void testCategorySearchReturnsTrueForExistingCategoryId() {
        // Arrange
        int categoryId = 1;
        Category category = new Category("Electronics", categoryId);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Electronics", categoryId, 1, "Laptop", 1000, 20, "Test"));
        Store.Category_product.put(category, products);

        // Act
        boolean result = Store.category_Search(categoryId);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Test Category Search Returns False For Non Existing Category")
    // 1
    public void testCategorySearchReturnsFalseForNonExistingCategoryId() {
        // Arrange
        int categoryId = 1;
        Category category = new Category("Electronics", categoryId);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Electronics", categoryId, 1, "Laptop", 1000, 20, "Test"));
        Store.Category_product.put(category, products);

        // Act
        boolean result = Store.category_Search(2);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Test Category Search Returns False For Empty CategoryProductMap")
    // 1
    public void testCategorySearchReturnsFalseForEmptyCategoryProductMap() {
        // Arrange
        Store.Category_product.clear();

        // Act
        boolean result = Store.category_Search(1);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Test Customer Search Returns True For Existing Customer")
    // 2
    public void testCustomerSearch() {

        // Create some test customers
        Customer c1 = new Customer("Alice", "password1");
        Customer c2 = new Customer("Bob", "password2");
        Customer c3 = new Customer("Charlie", "password3");

        // Add the customers to the store's record
        Store.Customer_record.put(1, c1);
        Store.Customer_record.put(2, c2);
        Store.Customer_record.put(3, c3);

        // Test valid login
        assertTrue(Store.customer_Search("ted", "123"));
        assertTrue(Store.customer_Search("robin", "456"));
        assertTrue(Store.customer_Search("lily", "789"));

        // Remove the customers from the store's record
        Store.Customer_record.remove(1);
        Store.Customer_record.remove(2);
        Store.Customer_record.remove(3);
    }

    @Test
    @DisplayName("Test Customer Search Returns False For Non-Existing Customer")
    // 2
    public void testCustomerSearch_False() {

        // Create some test customers
        Customer c1 = new Customer("Alice", "password1");
        Customer c2 = new Customer("Bob", "password2");
        Customer c3 = new Customer("Charlie", "password3");

        // Add the customers to the store's record
        Store.Customer_record.put(1, c1);
        Store.Customer_record.put(2, c2);
        Store.Customer_record.put(3, c3);

        // Test invalid login
        assertFalse(Store.customer_Search("ted", "lala"));
        assertFalse(Store.customer_Search("robin", "hehe"));
        assertFalse(Store.customer_Search("lily", "nono"));

        // Remove the customers from the store's record
        Store.Customer_record.remove(1);
        Store.Customer_record.remove(2);
        Store.Customer_record.remove(3);
    }

    @Test
    @DisplayName("Test Product Search Returns True For Existing Product")
    //3
    public void testProdSea() {
        // create some test products
        Category category = new Category("Books", 0);
        Product p1 = new Product("Books", 0, 0, "Bok Bok", 10.0, 2, "Irritating");
        Product p2 = new Product("Books", 0, 1, "Booo", 20.0, 3, "Bhut");
        Product p3 = new Product("Books", 0, 2, "Balish", 30.0, 1, "Sleep");

        // add the products to the store's record
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        Store.Category_product.put(category, products);

        // test that the prod_sea method returns true for an existing product id
        assertTrue(Store.prod_sea(1));
    }

    @Test
    @DisplayName("Test Product Search Returns False For Non-Existing Product")
    //3
    public void testProdSea_False() {
        // create some test products
        Category category = new Category("Books", 0);
        Product p1 = new Product("Books", 0, 0, "Bok Bok", 10.0, 2, "Irritating");
        Product p2 = new Product("Books", 0, 1, "Booo", 20.0, 3, "Bhut");
        Product p3 = new Product("Books", 0, 2, "Balish", 30.0, 1, "Sleep");

        // add the products to the store's record
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        Store.Category_product.put(category, products);

        // test that the prod_sea method returns false for a non-existing product id
        assertFalse(Store.prod_sea(4));
    }

    @Test
    @DisplayName("Test Product Category Search Returns True For Existing Product")
    //4
    public void testProductSearch() {
        // Create some products
        Category category = new Category("Books", 0);
        Category category1 = new Category("Food", 1);
        Category category2 = new Category("Drinks", 2);

        Product p1 = new Product("Books", 0, 0, "Bok Bok", 10.0, 2, "Irritating");
        Product p2 = new Product("Food", 1, 1, "Booo", 20.0, 3, "Bhut");
        Product p3 = new Product("Drinks", 2, 2, "Balish", 30.0, 1, "Sleep");

        // add the products to the store's record
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        Store.Category_product.put(category, products);
        Store.Category_product.put(category, products);
        Store.Category_product.put(category1, products);
        Store.Category_product.put(category2, products);

        // Test product search with existing product
        assertTrue(Store.product_search(category, 1));

    }

    @Test
    @DisplayName("Test Product Category Search Returns False For Non Existing Product")
    //4
    public void testProductSearch1() {
        // Create some products
        Category category = new Category("Books", 0);
        Category category1 = new Category("Food", 1);
        Category category2 = new Category("Drinks", 2);

        Product p1 = new Product("Books", 0, 0, "Bok Bok", 10.0, 2, "Irritating");
        Product p2 = new Product("Food", 1, 1, "Booo", 20.0, 3, "Bhut");
        Product p3 = new Product("Drinks", 2, 2, "Balish", 30.0, 1, "Sleep");

        // add the products to the store's record
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        Store.Category_product.put(category, products);
        Store.Category_product.put(category1, products);
        Store.Category_product.put(category2, products);

        // Test product search with existing product
        assertFalse(Store.product_search(category, 3));
    }
}