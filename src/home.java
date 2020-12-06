import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class home extends Application {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public static void main(String[] args) {

        launch(args);
    }

    public static ArrayList<Patient> getPatients() {

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./data/patients.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Patient> Patients = new ArrayList<Patient>(0);
        ArrayList<Provider> Providers = new ArrayList<Provider>(0);


        for(int i=1; i<records.size(); i++) {
            List<String> fella = records.get(i);
            Patient newPatient = new Patient(fella.get(0),
                    fella.get(1),
                    fella.get(2),
                    fella.get(3),
                    fella.get(4),
                    fella.get(5),
                    fella.get(6),
                    fella.get(7),
                    Integer.parseInt(fella.get(8)),
                    Integer.parseInt(fella.get(9)),
                    Boolean.parseBoolean(fella.get(10)),
                    Integer.parseInt(fella.get(11)),
                    Boolean.parseBoolean(fella.get(12)),
                    fella.get(13),
                    Boolean.parseBoolean(fella.get(14)));

            Patients.add(newPatient);

            String sex;
            switch(Integer.parseInt(fella.get(9))) {
                case 1 -> sex="Male";
                case 2 -> sex="Female";
                case 3 -> sex="Other";
                default -> sex="??";
            }

            String Ethnicity;
            if(Boolean.parseBoolean(fella.get(10))) {
                Ethnicity="Hispanic/Latino";
            } else {
                Ethnicity="Not Hispanic/Latino";
            }

            String Race;

            switch(Integer.parseInt(fella.get(11))) {
                case 1 -> Race="White";
                case 2 -> Race="Black/African American";
                case 3 -> Race="First Nation/Native American";
                case 4 -> Race="Asian/Pacific Islander";
            }

            String Symptoms;
            if (Boolean.parseBoolean(fella.get(12))) {
                Symptoms="Symptomatic";
            } else {
                Symptoms="Non-Symptomatic";
            }

            String Status;
            if (Boolean.parseBoolean(fella.get(14))) {
                Status = "Positve";
            } else {
                Status = "Negative";
            }
        }
        return Patients;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Pull User Data from CSV
        //

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Split.fxml"));
            primaryStage.setTitle("MR COVID-19 DASHBOARD");
            primaryStage.getIcons().add(new Image("https://images.theconversation.com/files/319386/original/file-20200309-167285-1p9yqjv.png?ixlib=rb-1.1.0&q=45&auto=format&w=1000&fit=clip"));
            Scene scene = new Scene(root, 1000, 600);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);


            primaryStage.show();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,e.getMessage());
        }
    }
}