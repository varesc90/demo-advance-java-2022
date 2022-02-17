package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Speaker Experience = 3, Fee should be 250")
    void case07() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        speaker.setEmail("ming@live.com");
        speaker.setExp(3);
        Exception exception = assertThrows(SaveSpeakerException.class, () -> business.register(null, speaker));
        assertEquals(250, speaker.getRegistrationFee());
        assertEquals("Can't save a speaker.",exception.getMessage());

    }

    @Test
    @DisplayName("Speaker Experience = 5, Fee should be 250")
    void case08() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        speaker.setEmail("ming@live.com");
        speaker.setExp(5);
        Exception exception = assertThrows(SaveSpeakerException.class, () -> business.register(null, speaker));
        assertEquals(100, speaker.getRegistrationFee());
        assertEquals("Can't save a speaker.",exception.getMessage());

    }

    @Test
    @DisplayName("Speaker Experience = 5, Fee should be 250")
    void case09() {
        RegisterBusiness business = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("firstname");
        speaker.setLastName("lastname");
        speaker.setEmail("ming@live.com");
        speaker.setExp(9);
        Exception exception = assertThrows(SaveSpeakerException.class, () -> business.register(null, speaker));
        assertEquals(50, speaker.getRegistrationFee());
        assertEquals("Can't save a speaker.",exception.getMessage());

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