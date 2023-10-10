package lesson18;

import base.ConsoleUtil;
import base.Runnable;
import lesson18.task2.FileTools;
import lesson18.task2.XMLParserDOM;
import lesson18.task2.XMLParserSAX;

import java.util.Arrays;
import java.util.List;

/*Задача *:
Дополнительно реализовать следующий функционал: если с консоли введено значение 1
- распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
документ с помощью DOM.*/
public class L18Task2 extends Runnable {

    private static final int DOM_METHOD = 1;
    private static final int SAX_METHOD = 2;

    public L18Task2() {
        super("DOM и SAX");
    }

    @Override
    public void run() {
        String xmlFilePath = "src/lesson18/xml/task1.xml";
        List<String> tagList = Arrays.asList("firstName", "lastName", "title", "line");

        StringBuilder fileName = new StringBuilder("firstName_lastName_title.txt");

        String parsedData = null;
        switch ((int) ConsoleUtil.getNumberInRange("Выберите метод (1 - DOM, 2 - SAX):", DOM_METHOD, SAX_METHOD)) {
            case DOM_METHOD -> parsedData = XMLParserDOM.parseByTagList(xmlFilePath, tagList, fileName);
            case SAX_METHOD -> parsedData = XMLParserSAX.parseByTagList(xmlFilePath, tagList, fileName);
        }

        String txtFilePath = fileName.insert(0, "src/lesson18/txt/").toString();

        FileTools.clearFiles(txtFilePath);

        FileTools.writeDataToFile(txtFilePath, parsedData);

        ConsoleUtil.println("Записанные данные в файл " + txtFilePath + ":\n" + parsedData);
    }


}
