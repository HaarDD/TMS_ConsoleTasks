package lesson18;

import base.Runnable;
import lesson18.task2.FileTools;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.FileReader;

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
        String xmlFilePath = "src/lesson18/xml/";
        String txtFilePath = "src/lesson18/txt/";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            try (BufferedReader xmlReader = new BufferedReader(new FileReader(xmlFilePath + "task1.xml"))) {
                Document xmlDocument = builder.parse(new InputSource(xmlReader));

                NodeList sonnetsNodeList = xmlDocument.getElementsByTagName("sonnet");

                for (int i = 0; i < sonnetsNodeList.getLength(); i++) {
                    Element currentSonnetElement = (Element) sonnetsNodeList.item(i);

                    String sonnetType = currentSonnetElement.getAttribute("type");
                    String firstName = currentSonnetElement.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = currentSonnetElement.getElementsByTagName("lastName").item(0).getTextContent();
                    String title = currentSonnetElement.getElementsByTagName("title").item(0).getTextContent();

                    String fileName = firstName + '_' + lastName + '_' + title + ".txt";

                    StringBuilder txtFileData = new StringBuilder();
                    txtFileData.append("---New sonnet---\n")
                            .append(sonnetType).append('\n')
                            .append(firstName).append('\n')
                            .append(lastName).append('\n')
                            .append(title).append('\n');

                    NodeList linesNodeList = currentSonnetElement.getElementsByTagName("line");

                    txtFileData.append("--Lines--\n");

                    for (int j = 0; j < linesNodeList.getLength(); j++) {
                        Element currentLineElement = (Element) linesNodeList.item(j);
                        String currentLineText = currentLineElement.getTextContent();

                        txtFileData.append(currentLineText).append('\n');
                    }

                    FileTools.clearFiles(txtFilePath + fileName);
                    FileTools.writeDataToFile(txtFilePath + fileName, txtFileData.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
