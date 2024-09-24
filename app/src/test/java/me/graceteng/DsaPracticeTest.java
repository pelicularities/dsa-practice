package me.graceteng;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DsaPracticeTest {
    @Test void shouldHaveGreeting() {
        DsaPractice classUnderTest = new DsaPractice();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
