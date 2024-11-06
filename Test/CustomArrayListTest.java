import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    private CustomArrayList<Double> newArr;

    @BeforeEach
    public void setUp() {
        newArr = new CustomArrayList<>(Double.class, 10);
        for(double i = 0.0; i < 60; i += 10) {
            newArr.addElement(i);
        }
        newArr.addElement(5.0);
        newArr.addElement(3.0);
        newArr.addElement(4.0);
    }

    @Test
    public void testAddAndGetElement() {
        assertEquals(0.0, newArr.getElement(0));
        assertEquals(10.0, newArr.getElement(1));
        assertEquals(5.0, newArr.getElement(6));
        assertEquals(4.0, newArr.getElement(8));
    }

    @Test
    public void testIndexOf() {
        assertEquals(3, newArr.indexOf(30.0));
        assertEquals(6, newArr.indexOf(5.0));
        assertEquals(-1, newArr.indexOf(100.0)); // Value not in list
    }

    @Test
    public void testRevert() {
        newArr.revert();
        assertEquals(4.0, newArr.getElement(0));
        assertEquals(3.0, newArr.getElement(1));
        assertEquals(5.0, newArr.getElement(2));
        assertEquals(0.0, newArr.getElement(8));
    }

    @Test
    public void testToString() {
        String expectedString = "0.0, 10.0, 20.0, 30.0, 40.0, 50.0, 5.0, 3.0, 4.0, ";
        assertEquals(expectedString, newArr.toString());
    }

    @Test
    public void testSort() {
        newArr.sort();
        String expectedSortedString = "0.0, 3.0, 4.0, 5.0, 10.0, 20.0, 30.0, 40.0, 50.0, ";
        assertEquals(expectedSortedString, newArr.toString());
    }
}
