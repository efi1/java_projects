import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        ContactsManager tester = new ContactsManager(); // MyClass is tested

        // assert statements
//        assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
        System.out.println(tester.getContacts());
    }
}