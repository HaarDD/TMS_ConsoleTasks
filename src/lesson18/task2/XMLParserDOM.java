package lesson18.task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

public class XMLParserDOM {
    public static String parseByTagList(String xmlFilePath, List<String> tagList, StringBuilder fileName) {
        StringBuilder result = new StringBuilder();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new File(xmlFilePath));

            Element rootElement = xmlDocument.getDocumentElement();
            parseElement(rootElement, tagList, result, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static void parseElement(Element element, List<String> tagList, StringBuilder result, StringBuilder fileName) {
        String tagName = element.getTagName();

        if (tagList.contains(tagName)) {
            int tagIndex = fileName.indexOf(tagName);
            if (tagIndex != -1) {
                fileName.replace(tagIndex, tagIndex + tagName.length(), element.getTextContent());
            }
            result.append(element.getTextContent()).append('\n');
        }

        NodeList childNodes = element.getChildNodes();

        if (hasNodeChildElements(element)) {
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i) instanceof Element) {
                    parseElement((Element) childNodes.item(i), tagList, result, fileName);
                }
            }
        }
    }

    private static boolean hasNodeChildElements(Element element) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                return true;
            }
        }
        return false;
    }

}
