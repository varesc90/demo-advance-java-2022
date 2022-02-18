package register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {
    @Test
    void c1(){
        DB db = new DB(){

            @Override
            int increaseOne(int id) {
                return 2;
            }
        };
        DemoService demoService = new DemoService(db);
        String result = demoService.compute(1);
        assertEquals("Result = 2", result);
    }
}