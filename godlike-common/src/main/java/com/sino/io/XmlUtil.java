package com.sino.io;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml工具
 */
public class XmlUtil {
    /**
     * @param in 文件输入流
     * @param xmlPo    目标类
     * @return 目标类
     */
    public static Object getObject(InputStream in, Object xmlPo) {
        XStream xstream = new XStream(new DomDriver("utf-8"));
        xstream.processAnnotations(xmlPo.getClass());
        try {
            xmlPo = xstream.fromXML(in);
        } catch (Exception e) {
            throw new RuntimeException("load error!");
        }
        return xmlPo;
    }
    /**
     * @param filePath 文件路径
     * @param xmlPo    目标类
     * @return 目标类
     */
    public static Object getObject(String filePath, Object xmlPo) {
        XStream xstream = new XStream(new DomDriver("utf-8"));
        xstream.processAnnotations(xmlPo.getClass());
        try {
            xmlPo = xstream.fromXML(new ClassPathResource(filePath).getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("load " + filePath + " error!");
        }
        return xmlPo;
    }

    /**
     * 读取xml文件
     *
     * @param filePath xml文件路径
     * @return xmlDocument
     */
    public static Document read(String filePath) {
        SAXReader saxReader = new SAXReader();
        Document doc = null;
        try {
            doc = saxReader.read(new ClassPathResource(filePath).getInputStream());
        } catch (Exception e) {
            System.err.println("读取" + filePath + "文件失败" + e.getMessage());
            System.err.println(e.getLocalizedMessage());
        }
        return doc;
    }

    /**
     * 获取xml文件的根节点
     *
     * @param doc xmlDocument
     * @return 根节点
     */
    public static Element getRootElement(Document doc) {
        Element root = doc.getRootElement();
        return root;

    }

    public static String getCurrentElementName(Element element) {
        return element.getName();
    }

    /**
     * @param element 节点
     * @return 属性的键值对
     */
    public static Map<String, String> getElementAttributes(Element element) {
        Map<String, String> map = new HashMap<>();
        List<Attribute> listAttr = element.attributes();
        if (listAttr != null) {
            for (Attribute attr : listAttr) {
                String attrName = attr.getName();
                String attrValue = attr.getValue();
                map.put(attrName, attrValue);
            }
        }
        return map;
    }

    /**
     * @param element 节点
     * @return 子节点的键值对，key为子节点的名称
     */
    public static Map<String, Element> getElementChild(Element element) {
        Map<String, Element> map = new HashMap<>();
        List<Element> listElement = element.elements();
        if (listElement != null) {
            for (Element e : listElement) {
                String name = e.getName();
                map.put(name, e);
            }
        }
        return map;
    }


}
