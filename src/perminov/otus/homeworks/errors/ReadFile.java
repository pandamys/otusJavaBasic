package perminov.otus.homeworks.errors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public ArrayList<String> readFile(String pathToFile){
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            while (br.ready()){
                lines.add(br.readLine());
            }
        } catch (IOException e){
            System.out.println("File not found: " + pathToFile);
        }
        return lines;
    }
}
