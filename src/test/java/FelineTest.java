import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {
    @Test
    public void getFamilyShouldReturnFeline() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoParamsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

   @ParameterizedTest
   @ValueSource(ints = {0, 2})
    public void getKittensZeroTwoReturnZeroTwo(int parms) {
       Feline feline = new Feline();
       assertEquals(parms, feline.getKittens(parms));
   }

   @Test
    public void eatMeatPredatorReturnGetFood() throws Exception {
       Feline feline = new Feline();
       List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
       assertEquals(expectedFood, feline.eatMeat());
   }
}