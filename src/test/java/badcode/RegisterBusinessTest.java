package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("check Speaker = null should throw runtime exception")
    void case01() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(RuntimeException.class, () -> business.register(null,null));
        assertEquals("Speaker is null",exception.getMessage());

    }

    @Test
    @DisplayName("First name = null, Argument Exception should be thrown")
    void case02() {
        RegisterBusiness business = new RegisterBusiness();


        Exception exception = assertThrows(ArgumentNullException.class, () -> business.register(null, new Speaker()));
        assertEquals("First name is required.",exception.getMessage());

    }

    @Test
    @DisplayName("Last name = null, Argument Exception should be thrown")
    void case03() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        Exception exception = assertThrows(ArgumentNullException.class, () -> business.register(null, speaker));
        assertEquals("Last name is required.",exception.getMessage());

    }

    @Test
    @DisplayName("Email = null, Argument Exception should be thrown")
    void case04() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        Exception exception = assertThrows(ArgumentNullException.class, () -> business.register(null, speaker));
        assertEquals("Email is required.",exception.getMessage());

    }

    @Test
    @DisplayName("Invalid Domain, SpeakerDoesntMeetRequirementsException should be thrown")
    void case05() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        speaker.setEmail("ming@example.com");
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> business.register(null, speaker));
        assertEquals("Speaker doesn't meet our standard rules.",exception.getMessage());

    }

    @Test
    @DisplayName("Invalid Domain, SpeakerDoesntMeetRequirementsException should be thrown")
    void case06() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        speaker.setEmail("ming@live.com");
        Exception exception = assertThrows(SaveSpeakerException.class, () -> business.register(null, speaker));
        assertEquals("Can't save a speaker.",exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "0,500",
            "1,500",
            "2,250",
            "9,50",
            "10,0"
    })
    void case07(int expYear, int expectedFee) {
        RegisterBusiness business = new RegisterBusiness();
        int actualFee = business.getFee(expYear);
        assertEquals(expectedFee,actualFee);
    }

    @Test
    @DisplayName("Invalid email, SpeakerDoesntMeetRequirementsException should be thrown")
    void case10() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        speaker.setEmail("xxx");
        Exception exception = assertThrows(DomainEmailInvalidException.class, () -> business.register(null, speaker));

    }
}