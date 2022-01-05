package com.atguigu.projo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        try {
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read("src/books.xml");

            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws Exception {
        // 1 1读取xml
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            Element nameElement = book.element("name");
            System.out.println(nameElement.asXML());
            String text = nameElement.getText();
            System.out.println(text);


        }
    }
}
