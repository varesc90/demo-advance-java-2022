package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("check Speaker = null should throw runtime exception")
    void case01() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(RuntimeException.class, () -> { business.register(null,null); });
        assertEquals("Speaker is null",exception.getMessage());

    }

    @Test
    @DisplayName("First name = null, Argument Exception should be thrown")
    void case02() {
        RegisterBusiness business = new RegisterBusiness();


        Exception exception = assertThrows(ArgumentNullException.class, () -> {  business.register(null, new Speaker()); });
        assertEquals("First name is required.",exception.getMessage());

    }
}