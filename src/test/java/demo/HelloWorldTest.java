package demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    @DisplayName("Test Everything should run normals")
    void case1() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.hi("ming");
        assertEquals("Hello ming",result);
    }

    @Test
    void case2() {
    }
}