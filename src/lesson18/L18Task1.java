package lesson18;

import base.ConsoleUtil;
import base.Runnable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/*Задача 1:
Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
содержимое тегов line записать в другой документ. Название файла для записи должно
состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt*/
public class L18Task1 extends Runnable {

    public L18Task1() {
        super("Извлечение данных из xml с последующей записью в файл");
    }

    @Override
    public void run() {
        String xmlFilePath = "src/lesson18/xmls/";
        String txtFilePath = "src/lesson18/txts/";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document xmlDocument = builder.parse(new File(xmlFilePath + "task1.xml"));

            NodeList sonnetsNodeList = xmlDocument.getElementsByTagName("sonnet");

            StringBuilder txtFileData = new StringBuilder();

            StringBuilder fileName = new StringBuilder();

            for (int i = 0; i < sonnetsNodeList.getLength(); i++) {
                txtFileData.append("---New sonnet---\n");

                Element currentSonnetElement = (Element) sonnetsNodeList.item(i);

                String sonnetType = currentSonnetElement.getAttribute("type");

                String firstName = currentSonnetElement.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = currentSonnetElement.getElementsByTagName("lastName").item(0).getTextContent();
                String title = currentSonnetElement.getElementsByTagName("title").item(0).getTextContent();

                fileName.append(firstName).append('_').append(lastName).append('_').append(title).append(".txt");

                txtFileData.append(sonnetType).append('\n').append(firstName).append('\n').append(lastName).append('\n').append(title).append('\n');

                NodeList linesNodeList = currentSonnetElement.getElementsByTagName("line");

                txtFileData.append("--Lines--\n");

                for (int j = 0; j < linesNodeList.getLength(); j++) {
                    Element currentLineElement = (Element) linesNodeList.item(j);
                    String currentLineText = currentLineElement.getTextContent();

                    txtFileData.append(currentLineText).append('\n');
                }

            }

            clearFiles(txtFilePath + fileName);

            writeLineToFile(txtFilePath + fileName,txtFileData.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                ConsoleUtil.println("Не удалось очистить файл по пути \"" + path + "\"!");
            }
        }
    }



}
