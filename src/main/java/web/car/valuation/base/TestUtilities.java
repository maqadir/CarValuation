package web.car.valuation.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtilities extends BaseTest{

    protected static List<String> ReadFile(){
        String line;
        String pattern = "\\b[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}\\b";
        Pattern p  = Pattern.compile(pattern);
        List<String> reg = new ArrayList<>();
        try {

            File carInput = new File("src/main/resources/car_input.txt");
            Scanner inputScanner = new Scanner(carInput);
            while (inputScanner.hasNextLine()) {
                line = inputScanner.nextLine();
                Matcher m = p.matcher(line);
                while (m.find()){
                    reg.add(m.group().replaceAll("\\s+", ""));
                }
            }
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return reg;
    }

}
