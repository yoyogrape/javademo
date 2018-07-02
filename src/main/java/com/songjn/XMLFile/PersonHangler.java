package com.songjn.XMLFile;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-20 23:14
 * @desc SAX解析xml的工具类
 * 1、基于事件驱动
 * 2、顺序读取，速度快
 * 3、不能任意读取节点（灵活性稍差）
 * 4、解析时占用内存小
 * 5、SAX更适用于在性能要求更高的设备上使用（安卓开发中）
 **/
public class PersonHangler extends DefaultHandler {
    private List<Persion> persions = null;
    private Persion p;//当前正在解析的persion
    private String tag;//用于记录当前正在解析的标签名

    //开始解析文档时调用
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        persions = new ArrayList<Persion>();
        System.out.println("解析文档开始...");
    }

    //结束解析文档的时候调用
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析文档结束。");
    }

    /**
     * 开始标签（元素）调用的方法
     *
     * @param uri        命名空间（类似包名）
     * @param localName  不带前缀的标签名
     * @param qName      带前缀的标签名，如：<aa:persion>
     * @param attributes 当前标签的属性集合
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName
            , Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("contact".equals(qName)) {
            p = new Persion();
            String contactid = attributes.getValue("id");
            p.setContactid(contactid);
        }
        tag = qName;
    }

    //解析结束元素时调用
    @Override
    public void endElement(String uri, String localName
            , String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("contact".equals(qName)) {
            persions.add(p);
        }
        tag = null;
    }

    //解析到文档内容的时候调用（包括空格回车）
    @Override
    public void characters(char[] ch, int start
            , int length) throws SAXException {
        super.characters(ch, start, length);
        if (tag != null) {
            if ("name".equals(tag)) {
                p.setName(new String(ch, start, length));
            } else if ("telephone".equals(tag)) {
                p.setTelephone(new String(ch, start, length));
            } else if ("age".equals(tag)) {
                p.setAge(Integer.parseInt(new String(ch, start, length)));
            } else if ("email".equals(tag)) {
                p.setEmail(new String(ch, start, length));
            } else if ("qq".equals(tag)) {
                p.setQq(new String(ch, start, length));
            }
        }
    }

    public List<Persion> getPersions() {
        return persions;
    }
}