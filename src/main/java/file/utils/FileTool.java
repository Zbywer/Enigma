package file.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTool {
    public static String getFileContent(String pathToFile) {
        StringBuilder stringBuilder = new StringBuilder();
        //pobieramy ścieżkę ressource
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = reader.readLine(); // czytamy kolejną linię
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + pathToFile);
        } catch (IOException e) {
            System.out.println("Some problem with file ...:" + e);
        }
        return stringBuilder.toString();   //to co załadowało się do stringBuildera zczytujemy
    }
}