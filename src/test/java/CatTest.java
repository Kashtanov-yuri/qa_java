import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline mFeline = mock(Feline.class);

    @Test
    public void getSoundShouldReturnSoundMeow(){
        Cat cat = new Cat(mFeline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);

    }
    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Cat cat = new Cat(mFeline);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mFeline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
        verify(mFeline).eatMeat();
    }
}