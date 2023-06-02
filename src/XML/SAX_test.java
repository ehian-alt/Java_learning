package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


// 使用SAX解析
public class SAX_test {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1、获得工厂对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2、基于工厂获得解析器对象
        SAXParser saxParser = factory.newSAXParser();
        // 3、使用解析器解析xml   第二个参数DefaultHandler需要继承重写
        saxParser.parse(new File("E:\\IDEA\\Java_Project\\Hello_Java\\src\\XML\\XMLtest.xml"), new Myhandler());
    }
}

class Myhandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("文档解析开始");
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"---标签解析开始");
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        System.out.println("解析文本值为: " + str);
        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"---标签解析结束");
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档解析结束");
        super.endDocument();
    }
}