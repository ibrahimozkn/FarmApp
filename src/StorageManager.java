import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StorageManager {
    FarmMe farm;
    File animalStorage = new File("animal.txt");
    DataInputStream animalReader;
    DataOutputStream animalWriter;
    public void InitializeStorage() throws IOException {

        System.out.println(this.animalStorage.isFile());
        if(!this.animalStorage.isFile()){
            animalStorage.createNewFile();
        }

        animalReader = new DataInputStream(new BufferedInputStream(new FileInputStream(animalStorage)));
        animalWriter = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(animalStorage, true)));
    }

    public StorageManager(){
        this.farm = PopulateData.populate();
    }


    public void populateAnimalList() throws IOException{
        String raw = animalReader.readUTF();

        System.out.println(raw);

        String[] animalRaw = raw.split("_");

        ArrayList<Animal> animals = new ArrayList<>();

        for(int i = 0; i < animalRaw.length; i++){
            String[] animalDetails = animalRaw[i].split(";");

            if(animalDetails[0].toLowerCase() == "cow"){
                animals.add(new Cow(Integer.parseInt(animalDetails[1]),
                        animalDetails[2],
                        LocalDate.parse(animalDetails[3]),
                        animalDetails[4] == "1",
                        Double.parseDouble(animalDetails[5])));
            }else {
                animals.add(new Sheep(Integer.parseInt(animalDetails[1]),
                        animalDetails[2],
                        LocalDate.parse(animalDetails[3]),
                        animalDetails[4] == "1"));
            }

        }

        farm.animals = animals;
    }

    public void WriteAnimals() throws IOException{
        String animalFormat = "";
        for (Animal animal:farm.animals) {
            animalFormat = (animal instanceof Cow ? "Cow" : "Sheep") + ";";
            animalFormat += animal.getTagNo() + ";";
            animalFormat += animal.getGender() + ";";
            animalFormat += animal.getDateOfBirth() + ";";
            animalFormat += animal.getPurchased() + ";";

            if(animal instanceof Cow){
                animalFormat += ((Cow) animal).getWeight() + ";";
            }

            animalWriter.writeUTF(animalFormat + "_");
        }

        animalWriter.close();

    }


}
