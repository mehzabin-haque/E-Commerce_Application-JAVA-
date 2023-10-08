import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestingAdminClass {
    @Test
    @DisplayName("Test Admin Search Returns True For Existing Admin")
    //1
    public void testAdminSearch() {
        assertTrue(Admin.admin_Search("Vidur", "2021364"));
    }

    @Test
    @DisplayName("Test Admin Search Returns True For Existing Admin")
    //1
    public void testAdminSearch2() {
        assertTrue(Admin.admin_Search("A", "A"));
    }

    @Test
    @DisplayName("Test Admin Search Invalid")
    //1
    public void testAdminSearch3() {
        assertFalse(Admin.admin_Search("", ""));
    }


   
}
