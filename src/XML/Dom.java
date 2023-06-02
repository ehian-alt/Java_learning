package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Dom {
    // 用Dom 解析XML文件
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //1、获得document构建  工厂对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //2、获得documentBuilder对象
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        //3、获得document对象
        Document document = documentBuilder.parse("E:\\IDEA\\Java_Project\\Hello_Java\\src\\XML\\XMLtest.xml");
        //4、获得节点集合
        NodeList students = document.getElementsByTagName("Students");
        //5、获得根节点
        Node root = students.item(0);
        //6、获得子节点
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            //获得子节点不仅仅包含student还包含了空格
//            System.out.println(nodes.item(i));
            Node node = nodes.item(i);
            // == 1代表当前node是一个节点而不是文本
            if (node.getNodeType()==1){
                System.out.println(node.getNodeName());
                //获得student子节点
                NodeList childNodes = node.getChildNodes();
                // 获得包括id,name, age节点
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node node_info = childNodes.item(j);
                    //是节点信息则输出
                    if (node_info.getNodeType()==1){
                        System.out.println("  "+node_info.getNodeName()+"  " + node_info.getTextContent());
                    }
                }
            }
        }
    }
}
