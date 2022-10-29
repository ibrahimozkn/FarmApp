import java.time.LocalDate;
import java.util.ArrayList;

public class PopulateData {
    public static FarmMe populate(){
        ArrayList<Cow> cows = new ArrayList<Cow>();
        cows.add(new Cow(1, "male", LocalDate.now(), true));
        cows.add(new Cow(2, "female", LocalDate.of(2001, 1, 5), false));
        cows.add(new Cow(3, "male", LocalDate.of(2013, 9, 21), true));

        ArrayList<Veterinary> vets = new ArrayList<Veterinary>();

        vets.add(new Veterinary(1, "female", LocalDate.of(1997, 5, 7), 2500.0));
        vets.add(new Veterinary(1, "male", LocalDate.of(1998, 12, 27), 2700.0));
        vets.add(new Veterinary(1, "female", LocalDate.of(1999, 8, 20), 1500.0));

        return new FarmMe(cows, vets);
    }
}
