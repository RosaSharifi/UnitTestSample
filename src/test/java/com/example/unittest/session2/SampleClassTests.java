package com.example.unittest.session2;

import com.example.unittest.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class SampleClassTests {

    //start 2
    @Test
    @DisplayName("Sample test For Start")
    @Order(1)
    @Disabled("Disabled Until Jira #123 issue is resolved")
    @EnabledOnOs(value = {OS.MAC, OS.SOLARIS}, disabledReason = "this just for Mac and Solaris")
    @EnabledOnJre({JRE.JAVA_17, JRE.JAVA_16})
    @EnabledIfSystemProperty(named = "COMPANY_NAME", matches = "FANAP")
    @EnabledIfEnvironmentVariable(named = "COMPANY_NAME", matches = "FANAP")
    void testSample() {
        System.out.println("TestSample Running ...");
        // 1. SetUp : Create instance of class to test.
        SampleClass sampleClass = new SampleClass();
        int expected = 6;
        int unexpected = 8;

        // 2. Executed : call the method you want to test.
        int actual = sampleClass.add(2, 4);

        // 3. Assert : Check the actual result and verify that is the expected result.
        assertEquals(expected, actual, "2 + 4 must be 6");
        assertNotEquals(unexpected, actual, "2 + 4 must not be 8");
    }

    SampleClass sampleClass;

    @BeforeAll
    static void setUpAll() {
        System.out.println("@BeforeAll Running ...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll Running ...");
    }

    @BeforeEach
    void setUp() {
        sampleClass = new SampleClass();
        System.out.println("@BeforeEach Running ...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach Running ...");
    }

    @Test
    void testEqualsAndNotEquals() {
        System.out.println("testEqualsAndNotEquals Running ...");
        assertEquals(6, sampleClass.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(8, sampleClass.add(2, 4), "2 + 4 must not be 8");
    }

    @Test
    void testNullAndNotNull() {
        System.out.println("testNullAndNotNull Running ...");
        assertNull(sampleClass.checkNull(null), "Obj Should be Null");
        assertNotNull(sampleClass.checkNull("Rosa"), "Obj Should be NotNull");
    }

    @Test
    void testSameAndNotSame() { //check address of object
        System.out.println("testSameAndNotSame Running ...");
        String str = "academy2";
        assertSame(sampleClass.getAcademy(), sampleClass.getAcademy2(), "Obj Should Refer to Same Obj");
        assertNotSame(str, sampleClass.getAcademy(), "Obj Should Not Refer to Same Obj");
    }

    @Test
    void testSameAndNotSame2() { //check address of object
        System.out.println("testSameAndNotSame2 Running ...");
        Person person = new Person("ramin", 32);

        assertSame(sampleClass.getPerson(), sampleClass.getPerson2(), "Obj Should Refer to Same Obj");
        assertNotSame(person, sampleClass.getPerson(), "Obj Should Not Refer to Same Obj");
    }

    @Test
    void testTrueAndFalse() {
        System.out.println("testTrueAndFalse Running ...");
        assertTrue(sampleClass.isBigger(5, 1), "This should return TRUE");
        assertFalse(sampleClass.isBigger(2, 4), "This should return FALSE");
    }

    @Test
    void testArraysEquals() { //Arrays []
        System.out.println("testArraysEquals Running ...");
        String[] array = {"A", "B", "C"};
        assertArrayEquals(array, sampleClass.getAlphabetArray(), "Arrays should be equal");
    }

    @Test
    void testIterableEquals() { // Collections
        System.out.println("testIterableEquals Running ...");
        List<String> strings = List.of("str1,str2");
        assertIterableEquals(strings, sampleClass.getStrings(), "Lists should be equal");
    }

    @Test
    void testLinesMatch() { //TODO : what is exactly?
        System.out.println("testLinesMatch Running ...");
        List<String> strings = List.of("str1,str2");
        assertLinesMatch(strings, sampleClass.getStrings(), "Lists should be equal");
    }

    @Test
    void testThrows() {
        System.out.println("testThrows Running ...");
        assertThrows(Exception.class, () -> sampleClass.throwException(-1), "Should throw Exception");
        assertDoesNotThrow(() -> sampleClass.throwException(2), "Should not throw Exception");
    }

    @Test
    void testTimeoutPreemptively() {
        System.out.println("testTimeoutPreemptively Running ...");
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> sampleClass.checkTimeOut(), "Method Should execute in 3 min");
    }
    //end 2
}