package lesson18.task2;

import base.ConsoleUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTools {

    public static void writeDataToFile(String filePath, String line) {
        try (BufferedWriter output_file = new BufferedWriter(new FileWriter(filePath, true))) {
            output_file.write(line);
            output_file.newLine();
        } catch (IOException e) {
            ConsoleUtil.println("Не удалось записать строку в файл по пути \"" + filePath + "\"!");
        }
    }

    public static void clearFiles(String... filePath) {
        for (String path : filePath) {
            try {
                FileWriter output_file = new FileWriter(path);
                output_file.close();
            } catch (IOException e) {
                ConsoleUtil.println("Не удалось очистить файл по пути \"" + path + "\"!");
            }
        }
    }

}
