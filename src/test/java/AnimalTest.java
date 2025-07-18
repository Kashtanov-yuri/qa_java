import com.example.Animal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void getFoodHerbivorousGrassVariousPlants() throws Exception {
        Animal animal = new Animal();
        List<String> result = animal.getFood("Травоядное");
        assertIterableEquals(List.of("Трава", "Различные растения"), result);
    }

    @Test
    public void getFoodPredatorAnimalsBirdsFish() throws Exception {
        Animal animal = new Animal();
        List<String> result = animal.getFood("Хищник");
        assertIterableEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Всеядное", "Гусь", "123"})
    public void getFoodExceptionWhenInvalidInput(String input) {
        Animal animal = new Animal();
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood(input);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getFamilyShouldReturnFixedString(){
        Animal animal = new Animal();
        String expectedResult  = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expectedResult, actual);
    }
}

