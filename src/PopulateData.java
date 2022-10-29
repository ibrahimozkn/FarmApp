import java.time.LocalDate;
import java.util.ArrayList;

public class PopulateData {
    public static FarmMe populate(){
        ArrayList<Cow> cows = new ArrayList<Cow>();
        cows.add(new Cow(1, "male", LocalDate.now(), true));
        cows.add(new Cow(2, "female", LocalDate.of(2001, 1, 5), false));
        cows.add(new Cow(3, "male", LocalDate.of(2013, 9, 21), true));

        return new FarmMe(cows);
    }
}
