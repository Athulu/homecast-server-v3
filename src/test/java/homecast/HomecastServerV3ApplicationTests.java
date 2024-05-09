package homecast;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class HomecastServerV3ApplicationTests {

    @Test
    void contextLoads() {
        // given
        int a = 1;
        int b = 1;

        // when
        int result = a + b;

        // then
        assertEquals(2, result);
    }

}
