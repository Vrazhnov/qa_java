import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {
    private final String sex;
    private final boolean expectedHasMane;

    public ParameterizedLionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true}, {"Самка", false}, {"Самсамка", false}
        };
    }

    @Test
    public void createLionEntityTest() {
        Lion lion;
        try {
            lion = new Lion(sex, new Feline());
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
        } catch (Exception actual) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", actual.getMessage());
        }
    }
}