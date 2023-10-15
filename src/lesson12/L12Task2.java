package lesson12;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*Задача *:
Допустим есть txt файл с номерами документов. Номером документа является строка,
состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый
номер документа с новой строки и в строке никакой другой информации, только номер
документа. Валидный номер документа должен иметь длину 15 символов и начинаться с
последовательности docnum(далее любая последовательность букв/цифр) или
contract(далее любая последовательность букв/цифр). Написать программу для чтения
информации из входного файла - путь к входному файлу должен задаваться через
консоль. Программа должна проверять номера документов на валидность. Валидные
номера документов следует записать в один файл-отчет. Невалидные номера документов
следует записать в другой файл-отчет, но после номеров документов следует добавить
информацию о том, почему этот документ не валиден.*/
public class L12Task2 extends TaskRunnable {

    public L12Task2() {
        super("Запись результатов валидации в отдельные файлы номеров документа из файла");
    }

    @Override
    public void runTask() {
        String documentNumbersFile = "src/lesson12/task2/document_numbers";
        String validDocumentNumbersFile = "src/lesson12/task2/valid_document_numbers";
        String invalidDocumentNumbersFile = "src/lesson12/task2/invalid_document_numbers";

        Map<Integer, String> validErrorCodes = new HashMap<>();
        validErrorCodes.put(1, "Длина номера документа не равна 15 символов");
        validErrorCodes.put(2, "Номер документа не начинается с docnum или contract");
        validErrorCodes.put(3, "Номер документа имеет недопустимые символы");

        clearFiles(validDocumentNumbersFile, invalidDocumentNumbersFile);

        for (String docNum : getDocNumsArrayFromFile(documentNumbersFile)) {
            List<Integer> docNumErrors = getDocNumErrorCodes(docNum);
            if (docNumErrors.isEmpty()) {
                writeLineToFile(validDocumentNumbersFile, docNum);
            } else {
                writeLineToFile(invalidDocumentNumbersFile, docNum + " " + docNumErrors.stream().map(validErrorCodes::get)
                        .collect(StringBuilder::new, (stringBuilder, str) -> stringBuilder.append(str).append(' '), StringBuilder::append));
            }
        }
    }

    public String[] getDocNumsArrayFromFile(String filePath) {
        try {
            BufferedReader input_file = new BufferedReader(new FileReader(filePath));
            return input_file.lines().toArray(String[]::new);
        } catch (IOException e) {
            ConsoleUtil.println("Не удалось прочитать файл по пути \"" + filePath + "\"!");
        }
        return new String[]{" "};
    }

    public void writeLineToFile(String filePath, String line) {
        try (BufferedWriter output_file = new BufferedWriter(new FileWriter(filePath, true))) {
            output_file.write(line);
            output_file.newLine();
        } catch (IOException e) {
            ConsoleUtil.println("Не удалось записать строку в файл по пути \"" + filePath + "\"!");
        }
    }

    public void clearFiles(String... filePath) {
        for (String path : filePath) {
            try {
                FileWriter output_file = new FileWriter(path);
                output_file.close();
            } catch (IOException e) {
                ConsoleUtil.println("Не очистить файл по пути \"" + path + "\"!");
            }
        }
    }

    public List<Integer> getDocNumErrorCodes(String docNum) {
        List<Integer> errorCodes = new ArrayList<>();
        if (docNum.length() != 15) errorCodes.add(1);
        if (!(docNum.startsWith("docnum") || docNum.startsWith("contract"))) errorCodes.add(2);
        if (docNum.chars().anyMatch(character -> !Character.isLetter(character) && !Character.isDigit(character)))
            errorCodes.add(3);
        return errorCodes;
    }
}
