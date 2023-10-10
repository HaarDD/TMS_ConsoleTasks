package lesson18.task2;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class XMLParserSAX {
    public static String parseByTagList(String xmlFilePath, List<String> tagList, StringBuilder fileName) {
        StringBuilder result = new StringBuilder();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                private final StringBuilder currentText = new StringBuilder();

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    currentText.setLength(0);
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    currentText.append(ch, start, length);
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    if (tagList.contains(qName)) {
                        int tagIndex = fileName.indexOf(qName);
                        if (tagIndex != -1) {
                            fileName.replace(tagIndex, tagIndex + qName.length(), currentText.toString());
                        }
                        result.append(currentText).append('\n');
                    }
                }
            };

            saxParser.parse(new File(xmlFilePath), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}