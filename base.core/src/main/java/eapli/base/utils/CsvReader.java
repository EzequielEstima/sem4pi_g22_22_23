package eapli.base.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public boolean importCsvData(String fileName, List<String> studentIdList){
        String fileLine = "";

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine();

            while ((fileLine = bufferedReader.readLine()) != null){
                studentIdList.add(fileLine);
            }

        } catch (FileNotFoundException e) {
            System.out.println("There is no csv file with the chosen name!\n");
            return false;
        } catch (IOException e){
            System.out.println("Couldn't properly read the data!\n");
            return false;
        }

       return true;
    }
}
