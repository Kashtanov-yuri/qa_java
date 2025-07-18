import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline mockFeline = mock(Feline.class);
    Lion lion;

    @BeforeEach
    public void setUp() throws Exception {
        lion = new Lion("Самка");
        injectMockFeline(lion, mockFeline);
    }

    private void injectMockFeline(Lion lion, Feline feline) throws Exception {
        Field felineField = Lion.class.getDeclaredField("feline");
        felineField.setAccessible(true);
        felineField.set(lion, feline);
    }

    @Test
    public void lionMaleTrue() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionFemaleFalse() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Гусь", "123"})
    public void LionExceptionWhenInvalidInput(String input) {
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(input);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getKittensReturnFeline() {
        when(mockFeline.getKittens()).thenReturn(5);
        int result = lion.getKittens();
        assertEquals(5, result);
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
}