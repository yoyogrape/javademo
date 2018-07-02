package com.songjn.XMLFile;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-20 21:38
 * @desc xml文件的解析过程
 **/
public class XMLDemo {
    //---SAX解析
    @Test
    public void saxPerseXML() throws ParserConfigurationException, SAXException, IOException {
        //1、创建一个sax解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2、通过工厂对象创建sax解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3、创建一个数据处理器
        PersonHangler personHangler = new PersonHangler();
        //4、开始解析
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/XMLFile/persion.xml");
        saxParser.parse(is, personHangler);
        List<Persion> persions = personHangler.getPersions();
        persions.forEach(System.out::println);
    }

    //DOM解析xml文件
    @Test
    public void domPerseXML() throws ParserConfigurationException, IOException, SAXException {
        //1、创建一个DOM解析器工厂对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2、通过工厂对象创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //3、解析文档
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/XMLFile/persion.xml");
        //此代码完成后，整个xml文档已被加载到内存中，以树状形式存储
        Document doc = documentBuilder.parse(is);
        //4、从内存中读取数据
        //获取节点名称为contact的所有节点，返回节点集合
        NodeList contactList = doc.getElementsByTagName("contact");
        ArrayList<Persion> persions = new ArrayList<>();
        Persion p = null;
        for (int i = 0; i < contactList.getLength(); i++) {
            Node contact = contactList.item(i);
            p = new Persion();
            String id = contact.getAttributes().getNamedItem("id").getNodeValue();
            p.setContactid(id);
            //获取当前节点的子节点
            NodeList childNodes = contact.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if ("name".equals(nodeName)) {
                    //获得name中文字子节点然后再getNodeValue
                    p.setName(item.getFirstChild().getNodeValue());
                } else if ("telephone".equals(nodeName)) {
                    p.setTelephone(item.getFirstChild().getNodeValue());
                } else if ("age".equals(nodeName)) {
                    p.setAge(Integer.valueOf(item.getFirstChild().getNodeValue()));
                } else if ("email".equals(nodeName)) {
                    p.setEmail(item.getFirstChild().getNodeValue());
                } else if ("qq".equals(nodeName)) {
                    p.setQq(item.getFirstChild().getNodeValue());
                }
            }
            persions.add(p);
        }
        persions.forEach(System.out::println);
    }

    /**
     * JDOM解析xml文件
     * 1、和DOM类似，基于树形结构
     * 2、与DOM区别：
     * ①第三方开源组件
     * ②实现使用JAVA的Collection接口
     * ③效率比DOM快
     *
     * @throws JDOMException
     * @throws IOException
     */
    @Test
    public void jdomPerseXML() throws JDOMException, IOException {

        //创建JDOM解析器
        SAXBuilder builder = new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/XMLFile/persion.xml");
        org.jdom2.Document build = builder.build(is);
        Element rootElement = build.getRootElement();
        List<Persion> list = new ArrayList<>();
        Persion p = null;
        List<Element> children = rootElement.getChildren();
        for (Element child : children) {
            p = new Persion();
            String id = child.getAttributeValue("id");
            p.setContactid(id);
            List<Element> children1 = child.getChildren();
            for (Element element : children1) {
                String tag = element.getName();
                if ("name".equals(tag)) {
                    p.setName(element.getText());
                } else if ("age".equals(tag)) {
                    p.setAge(Integer.valueOf(element.getText()));
                } else if ("telephone".equals(tag)) {
                    p.setTelephone(element.getText());
                } else if ("email".equals(tag)) {
                    p.setEmail(element.getText());
                } else if ("qq".equals(tag)) {
                    p.setQq(element.getText());
                }
            }
            list.add(p);
        }
        list.forEach(System.out::println);
    }

    //DOM4J解析xml文件
    @Test
    public void dom4jPerseXML() throws DocumentException {
        //创建DOM4J解析器对象
        SAXReader saxReader = new SAXReader();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/XMLFile/persion.xml");
        //读取xml文件到内存
        org.dom4j.Document doc = saxReader.read(is);
        //获取根元素
        org.dom4j.Element rootElement = doc.getRootElement();
        //获取根元素的迭代器
        Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
        ArrayList<Persion> persionArrayList = new ArrayList<>();
        Persion p = null;
        while (iterator.hasNext()) {//对子对象进行迭代
            p = new Persion();
            org.dom4j.Element contact = iterator.next();
            p.setContactid(contact.attributeValue("id"));
            Iterator<org.dom4j.Element> iterator1 = contact.elementIterator();
            while (iterator1.hasNext()) {//对子标签进行迭代
                org.dom4j.Element e = iterator1.next();
                String tag = e.getName();
                if ("name".equals(tag)) {
                    p.setName(e.getText());
                } else if ("age".equals(tag)) {
                    p.setAge(Integer.valueOf(e.getText()));
                } else if ("telephone".equals(tag)) {
                    p.setTelephone(e.getText());
                } else if ("email".equals(tag)) {
                    p.setEmail(e.getText());
                } else if ("qq".equals(tag)) {
                    p.setQq(e.getText());
                }
            }
            persionArrayList.add(p);
        }
        persionArrayList.forEach(System.out::println);
    }

}
