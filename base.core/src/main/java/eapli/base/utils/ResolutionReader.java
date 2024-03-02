package eapli.base.utils;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ResolutionReader {
    public static Map<Integer,List<String>> importAnswers(String fileName){
        Map<Integer,List<String>> answers = new HashMap<>();

        String fileLine;

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int i = 1;
            while ((fileLine = bufferedReader.readLine()) != null){

                List<String> questionAns;
                questionAns = Arrays.asList(fileLine.split(","));

                answers.put(i,questionAns);
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("There is no file with the chosen name!\n");
        } catch (IOException e){
            System.out.println("Couldn't properly read the data!\n");
        }

        return answers;
    }
}
